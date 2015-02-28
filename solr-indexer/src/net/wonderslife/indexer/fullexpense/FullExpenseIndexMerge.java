package net.wonderslife.indexer.fullexpense;

import java.io.File;
import java.io.IOException;

import net.wonderslife.util.PropertyUtil;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.apache.lucene.index.LogMergePolicy;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class FullExpenseIndexMerge {
	// 连接两个或多个索引

	private static void mergeIndex(File from, File to, StandardAnalyzer sa)
			throws IOException {
		long begin = System.currentTimeMillis();
		IndexWriter iw = null;

		System.out.println("Index merging, from " + from + " to " + to);

		Directory toD = FSDirectory.open(to);
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_47, sa);
		iwc.setOpenMode(OpenMode.CREATE_OR_APPEND); // 创建和添加索引

		LogMergePolicy mp = new LogByteSizeMergePolicy();
		mp.setMergeFactor(Integer.MAX_VALUE); // 提高批量速度
		mp.setMaxMergeDocs(Integer.MAX_VALUE);
		iwc.setMergePolicy(mp);

		iw = new IndexWriter(toD, iwc);
		Directory fromD = FSDirectory.open(from);
		iw.addIndexes(fromD);
		iw.commit();
		iw.close();
		System.out.println("Index merged.");
		long end = System.currentTimeMillis();
		System.out.println("merge spent:" + (end - begin) / 1000 + "s");

	}

	public static void main(String[] args) {
		try {
			String fromdir = PropertyUtil
					.get("solr.fullexpense.embedded.merge.fromdir");
			String todir = PropertyUtil
					.get("solr.fullexpense.embedded.merge.todir");
			int count = Integer.parseInt(PropertyUtil
					.get("solr.fullexpense.embedded.merge.threadcount"));
			File to = new File(todir);
			for (int i = 1; i <= count; i++) {
				File from = new File(fromdir + "/index" + i + "/data/index");
				FullExpenseIndexMerge.mergeIndex(from, to,
						new StandardAnalyzer(Version.LUCENE_47));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
