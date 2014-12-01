package net.wonderslife.indexer.pharma;

import org.apache.solr.client.solrj.beans.Field;

/**
 * 药品说明书
 * 
 * @author kuqi
 * 
 */
public class Pharma {
	@Field
	String BAZ001;
	@Field("通用名")
	String TYM;
	@Field("商品名")
	String SPM;
	@Field("生产企业")
	String SCQY;
	@Field("成份")
	String CF;
	@Field("适应症")
	String SYZ;
	@Field("规格")
	String GG;
	@Field("用法用量")
	String YFYL;
	@Field("不良反应")
	String BLFY;
	@Field("禁忌")
	String JJ;
	@Field("注意事项")
	String ZYSX;
	@Field("药物相互作用")
	String YWXHZY;
	@Field("药物分类")
	String YWFL;
	@Field("批准文号")
	String PZWH;
	@Field
	String owner;
	@Field
	String content_level;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getContent_level() {
		return content_level;
	}

	public void setContent_level(String content_level) {
		this.content_level = content_level;
	}

	public String getBAZ001() {
		return BAZ001;
	}

	public void setBAZ001(String bAZ001) {
		BAZ001 = bAZ001;
	}

	public String getTYM() {
		return TYM;
	}

	public void setTYM(String tYM) {
		TYM = tYM;
	}

	public String getSPM() {
		return SPM;
	}

	public void setSPM(String sPM) {
		SPM = sPM;
	}

	public String getSCQY() {
		return SCQY;
	}

	public void setSCQY(String sCQY) {
		SCQY = sCQY;
	}

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	public String getSYZ() {
		return SYZ;
	}

	public void setSYZ(String sYZ) {
		SYZ = sYZ;
	}

	public String getGG() {
		return GG;
	}

	public void setGG(String gG) {
		GG = gG;
	}

	public String getYFYL() {
		return YFYL;
	}

	public void setYFYL(String yFYL) {
		YFYL = yFYL;
	}

	public String getBLFY() {
		return BLFY;
	}

	public void setBLFY(String bLFY) {
		BLFY = bLFY;
	}

	public String getJJ() {
		return JJ;
	}

	public void setJJ(String jJ) {
		JJ = jJ;
	}

	public String getZYSX() {
		return ZYSX;
	}

	public void setZYSX(String zYSX) {
		ZYSX = zYSX;
	}

	public String getYWXHZY() {
		return YWXHZY;
	}

	public void setYWXHZY(String yWXHZY) {
		YWXHZY = yWXHZY;
	}

	public String getYWFL() {
		return YWFL;
	}

	public void setYWFL(String yWFL) {
		YWFL = yWFL;
	}

	public String getPZWH() {
		return PZWH;
	}

	public void setPZWH(String pZWH) {
		PZWH = pZWH;
	}

}
