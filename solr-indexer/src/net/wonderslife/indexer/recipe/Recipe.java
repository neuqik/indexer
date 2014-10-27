package net.wonderslife.indexer.recipe;

import org.apache.solr.client.solrj.beans.Field;

public class Recipe {
	@Field("定点医疗机构编码")
	String AKB020;

	public String getAKB020() {
		return AKB020;
	}

	public void setAKB020(String aKB020) {
		if ("".equals(aKB020) || aKB020 == null) {
			AKB020 = "无";
		} else {
			AKB020 = aKB020.trim();
		}
	}

	@Field("就诊流水号")
	String AKC190;

	public String getAKC190() {
		return AKC190;
	}

	public void setAKC190(String aKC190) {
		if ("".equals(aKC190) || aKC190 == null) {
			AKC190 = "无";
		} else {
			AKC190 = aKC190.trim();
		}
	}

	@Field("单据号")
	String AAE072;

	public String getAAE072() {
		return AAE072;
	}

	public void setAAE072(String aAE072) {
		if ("".equals(aAE072) || aAE072 == null) {
			AAE072 = "无";
		} else {
			AAE072 = aAE072.trim();
		}
	}

	@Field("处方号")
	String AKC220;

	public String getAKC220() {
		return AKC220;
	}

	public void setAKC220(String aKC220) {
		if ("".equals(aKC220) || aKC220 == null) {
			AKC220 = "无";
		} else {
			AKC220 = aKC220.trim();
		}
	}

	@Field("医院收费项目内码")
	String AKE005;

	public String getAKE005() {
		return AKE005;
	}

	public void setAKE005(String aKE005) {
		if ("".equals(aKE005) || aKE005 == null) {
			AKE005 = "无";
		} else {
			AKE005 = aKE005.trim();
		}
	}

	@Field("交易类型")
	String BKA135;

	public String getBKA135() {
		return BKA135;
	}

	public void setBKA135(String bKA135) {
		if ("".equals(bKA135) || bKA135 == null) {
			BKA135 = "无";
		} else {
			BKA135 = bKA135.trim();
		}
	}

	@Field("退费流水号")
	String BKC301;

	public String getBKC301() {
		return BKC301;
	}

	public void setBKC301(String bKC301) {
		if ("".equals(bKC301) || bKC301 == null) {
			BKC301 = "无";
		} else {
			BKC301 = bKC301.trim();
		}
	}

	@Field("药品/项目编码")
	String AKE001;

	public String getAKE001() {
		return AKE001;
	}

	public void setAKE001(String aKE001) {
		if ("".equals(aKE001) || aKE001 == null) {
			AKE001 = "无";
		} else {
			AKE001 = aKE001.trim();
		}
	}

	@Field("社保三大目录名称")
	String AKE002;

	public String getAKE002() {
		return AKE002;
	}

	public void setAKE002(String aKE002) {
		if ("".equals(aKE002) || aKE002 == null) {
			AKE002 = "无";
		} else {
			AKE002 = aKE002.trim();
		}
	}

	@Field("医院收费项目名称")
	String AKE006;

	public String getAKE006() {
		return AKE006;
	}

	public void setAKE006(String aKE006) {
		if ("".equals(aKE006) || aKE006 == null) {
			AKE006 = "无";
		} else {
			AKE006 = aKE006.trim();
		}
	}

	@Field("处方日期")
	String AKC221;

	public String getAKC221() {
		return AKC221;
	}

	public void setAKC221(String aKC221) {
		if ("".equals(aKC221) || aKC221 == null) {
			AKC221 = "无";
		} else {
			AKC221 = aKC221.trim();
		}
	}

	@Field("就诊结算日期")
	String AKE010;

	public String getAKE010() {
		return AKE010;
	}

	public void setAKE010(String aKE010) {
		if ("".equals(aKE010) || aKE010 == null) {
			AKE010 = "无";
		} else {
			AKE010 = aKE010.trim();
		}
	}

	@Field("收费项目等级")
	String AKA065;

	public String getAKA065() {
		return AKA065;
	}

	public void setAKA065(String aKA065) {
		if ("".equals(aKA065) || aKA065 == null) {
			AKA065 = "无";
		} else {
			AKA065 = aKA065.trim();
		}
	}

	@Field("收费项目种类")
	String AKE003;

	public String getAKE003() {
		return AKE003;
	}

	public void setAKE003(String aKE003) {
		if ("".equals(aKE003) || aKE003 == null) {
			AKE003 = "无";
		} else {
			AKE003 = aKE003.trim();
		}
	}

	@Field("收费类别")
	String AKA063;

	public String getAKA063() {
		return AKA063;
	}

	public void setAKA063(String aKA063) {
		if ("".equals(aKA063) || aKA063 == null) {
			AKA063 = "无";
		} else {
			AKA063 = aKA063.trim();
		}
	}

	@Field("单价")
	String AKC225;

	public String getAKC225() {
		return AKC225;
	}

	public void setAKC225(String aKC225) {
		if ("".equals(aKC225) || aKC225 == null) {
			AKC225 = "无";
		} else {
			AKC225 = aKC225.trim();
		}
	}

	@Field("数量")
	String AKC226;

	public String getAKC226() {
		return AKC226;
	}

	public void setAKC226(String aKC226) {
		if ("".equals(aKC226) || aKC226 == null) {
			AKC226 = "无";
		} else {
			AKC226 = aKC226.trim();
		}
	}

	@Field("金额")
	String AAE019;

	public String getAAE019() {
		return AAE019;
	}

	public void setAAE019(String aAE019) {
		if ("".equals(aAE019) || aAE019 == null) {
			AAE019 = "无";
		} else {
			AAE019 = aAE019.trim();
		}
	}

	@Field("自理金额")
	String AKC228;

	public String getAKC228() {
		return AKC228;
	}

	public void setAKC228(String aKC228) {
		if ("".equals(aKC228) || aKC228 == null) {
			AKC228 = "无";
		} else {
			AKC228 = aKC228.trim();
		}
	}

	@Field("自费金额")
	String AKE051;

	public String getAKE051() {
		return AKE051;
	}

	public void setAKE051(String aKE051) {
		if ("".equals(aKE051) || aKE051 == null) {
			AKE051 = "无";
		} else {
			AKE051 = aKE051.trim();
		}
	}

	@Field("最高限价")
	String AKA068;

	public String getAKA068() {
		return AKA068;
	}

	public void setAKA068(String aKA068) {
		if ("".equals(aKA068) || aKA068 == null) {
			AKA068 = "无";
		} else {
			AKA068 = aKA068.trim();
		}
	}

	@Field("超限价自付金额")
	String AKC268;

	public String getAKC268() {
		return AKC268;
	}

	public void setAKC268(String aKC268) {
		if ("".equals(aKC268) || aKC268 == null) {
			AKC268 = "无";
		} else {
			AKC268 = aKC268.trim();
		}
	}

	@Field("自付比例")
	String AKA069;

	public String getAKA069() {
		return AKA069;
	}

	public void setAKA069(String aKA069) {
		if ("".equals(aKA069) || aKA069 == null) {
			AKA069 = "无";
		} else {
			AKA069 = aKA069.trim();
		}
	}

	@Field("草药单复方标志")
	String BKC127;

	public String getBKC127() {
		return BKC127;
	}

	public void setBKC127(String bKC127) {
		if ("".equals(bKC127) || bKC127 == null) {
			BKC127 = "无";
		} else {
			BKC127 = bKC127.trim();
		}
	}

	@Field("处方药标志")
	String AKA064;

	public String getAKA064() {
		return AKA064;
	}

	public void setAKA064(String aKA064) {
		if ("".equals(aKA064) || aKA064 == null) {
			AKA064 = "无";
		} else {
			AKA064 = aKA064.trim();
		}
	}

	@Field("有效标志")
	String AAE100;

	public String getAAE100() {
		return AAE100;
	}

	public void setAAE100(String aAE100) {
		if ("".equals(aAE100) || aAE100 == null) {
			AAE100 = "无";
		} else {
			AAE100 = aAE100.trim();
		}
	}

	@Field("结算标志")
	String BKC126;

	public String getBKC126() {
		return BKC126;
	}

	public void setBKC126(String bKC126) {
		if ("".equals(bKC126) || bKC126 == null) {
			BKC126 = "无";
		} else {
			BKC126 = bKC126.trim();
		}
	}

	@Field("全额自费标志")
	String BKC125;

	public String getBKC125() {
		return BKC125;
	}

	public void setBKC125(String bKC125) {
		if ("".equals(bKC125) || bKC125 == null) {
			BKC125 = "无";
		} else {
			BKC125 = bKC125.trim();
		}
	}

	@Field("特殊项目标记")
	String BKA231;

	public String getBKA231() {
		return BKA231;
	}

	public void setBKA231(String bKA231) {
		if ("".equals(bKA231) || bKA231 == null) {
			BKA231 = "无";
		} else {
			BKA231 = bKA231.trim();
		}
	}

	@Field("审批编号")
	String BAE073;

	public String getBAE073() {
		return BAE073;
	}

	public void setBAE073(String bAE073) {
		if ("".equals(bAE073) || bAE073 == null) {
			BAE073 = "0";
		} else {
			BAE073 = bAE073.trim();
		}
	}

	@Field("基金支付金额(进入基金)")
	String BKA636;

	public String getBKA636() {
		return BKA636;
	}

	public void setBKA636(String bKA636) {
		if ("".equals(bKA636) || bKA636 == null) {
			BKA636 = "无";
		} else {
			BKA636 = bKA636.trim();
		}
	}

	@Field("非基金支付金额(进入基金)")
	String BKA637;

	public String getBKA637() {
		return BKA637;
	}

	public void setBKA637(String bKA637) {
		if ("".equals(bKA637) || bKA637 == null) {
			BKA637 = "无";
		} else {
			BKA637 = bKA637.trim();
		}
	}

	@Field("特殊项目个人直接支付比例")
	String BKA104;

	public String getBKA104() {
		return BKA104;
	}

	public void setBKA104(String bKA104) {
		if ("".equals(bKA104) || bKA104 == null) {
			BKA104 = "无";
		} else {
			BKA104 = bKA104.trim();
		}
	}

	@Field("剂型")
	String AKA070;

	public String getAKA070() {
		return AKA070;
	}

	public void setAKA070(String aKA070) {
		if ("".equals(aKA070) || aKA070 == null) {
			AKA070 = "无";
		} else {
			AKA070 = aKA070.trim();
		}
	}

	@Field("药品剂量单位")
	String AKA067;

	public String getAKA067() {
		return AKA067;
	}

	public void setAKA067(String aKA067) {
		if ("".equals(aKA067) || aKA067 == null) {
			AKA067 = "无";
		} else {
			AKA067 = aKA067.trim();
		}
	}

	@Field("规格")
	String AKA074;

	public String getAKA074() {
		return AKA074;
	}

	public void setAKA074(String aKA074) {
		if ("".equals(aKA074) || aKA074 == null) {
			AKA074 = "无";
		} else {
			AKA074 = aKA074.trim();
		}
	}

	@Field("经办人")
	String AAE011;

	public String getAAE011() {
		return AAE011;
	}

	public void setAAE011(String aAE011) {
		if ("".equals(aAE011) || aAE011 == null) {
			AAE011 = "无";
		} else {
			AAE011 = aAE011.trim();
		}
	}

	@Field("经办时间")
	String AAE036;

	public String getAAE036() {
		return AAE036;
	}

	public void setAAE036(String aAE036) {
		if ("".equals(aAE036) || aAE036 == null) {
			AAE036 = "无";
		} else {
			AAE036 = aAE036.trim();
		}
	}

	@Field("处方医师编号")
	String BKF050;

	public String getBKF050() {
		return BKF050;
	}

	public void setBKF050(String bKF050) {
		if ("".equals(bKF050) || bKF050 == null) {
			BKF050 = "无";
		} else {
			BKF050 = bKF050.trim();
		}
	}

	@Field("处方医师姓名")
	String AKC273;

	public String getAKC273() {
		return AKC273;
	}

	public void setAKC273(String aKC273) {
		if ("".equals(aKC273) || aKC273 == null) {
			AKC273 = "无";
		} else {
			AKC273 = aKC273.trim();
		}
	}

	@Field("每次用量")
	String AKA071;

	public String getAKA071() {
		return AKA071;
	}

	public void setAKA071(String aKA071) {
		if ("".equals(aKA071) || aKA071 == null) {
			AKA071 = "0";
		} else {
			AKA071 = aKA071.trim();
		}
	}

	@Field("使用频次")
	String AKA072;

	public String getAKA072() {
		return AKA072;
	}

	public void setAKA072(String aKA072) {
		if ("".equals(aKA072) || aKA072 == null) {
			AKA072 = "无";
		} else {
			AKA072 = aKA072.trim();
		}
	}

	@Field("用法")
	String AKA107;

	public String getAKA107() {
		return AKA107;
	}

	public void setAKA107(String aKA107) {
		if ("".equals(aKA107) || aKA107 == null) {
			AKA107 = "无";
		} else {
			AKA107 = aKA107.trim();
		}
	}

	@Field("单位")
	String BKA076;

	public String getBKA076() {
		return BKA076;
	}

	public void setBKA076(String bKA076) {
		if ("".equals(bKA076) || bKA076 == null) {
			BKA076 = "无";
		} else {
			BKA076 = bKA076.trim();
		}
	}

	@Field("科室名称")
	String AKF002;

	public String getAKF002() {
		return AKF002;
	}

	public void setAKF002(String aKF002) {
		if ("".equals(aKF002) || aKF002 == null) {
			AKF002 = "无";
		} else {
			AKF002 = aKF002.trim();
		}
	}

	@Field("执行天数")
	String BKC241;

	public String getBKC241() {
		return BKC241;
	}

	public void setBKC241(String bKC241) {
		if ("".equals(bKC241) || bKC241 == null) {
			BKC241 = "0";
		} else {
			BKC241 = bKC241.trim();
		}
	}

	@Field("人工晶体标识")
	String BKC243;

	public String getBKC243() {
		return BKC243;
	}

	public void setBKC243(String bKC243) {
		if ("".equals(bKC243) || bKC243 == null) {
			BKC243 = "无";
		} else {
			BKC243 = bKC243.trim();
		}
	}

	@Field("门诊统筹可用标志")
	String BKA205;

	public String getBKA205() {
		return BKA205;
	}

	public void setBKA205(String bKA205) {
		if ("".equals(bKA205) || bKA205 == null) {
			BKA205 = "无";
		} else {
			BKA205 = bKA205.trim();
		}
	}

	@Field("医疗类别")
	String AKA130;

	public String getAKA130() {
		return AKA130;
	}

	public void setAKA130(String aKA130) {
		if ("".equals(aKA130) || aKA130 == null) {
			AKA130 = "无";
		} else {
			AKA130 = aKA130.trim();
		}
	}

	@Field("项目对应的病种")
	String AKA120;

	public String getAKA120() {
		return AKA120;
	}

	public void setAKA120(String aKA120) {
		if ("".equals(aKA120) || aKA120 == null) {
			AKA120 = "无";
		} else {
			AKA120 = aKA120.trim();
		}
	}

	@Field("医疗类别对应的审批编号")
	String BAE075;

	public String getBAE075() {
		return BAE075;
	}

	public void setBAE075(String bAE075) {
		if ("".equals(bAE075) || bAE075 == null) {
			BAE075 = "0";
		} else {
			BAE075 = bAE075.trim();
		}
	}

	@Field("定点医疗机构经办人")
	String AAE017;

	public String getAAE017() {
		return AAE017;
	}

	public void setAAE017(String aAE017) {
		if ("".equals(aAE017) || aAE017 == null) {
			AAE017 = "无";
		} else {
			AAE017 = aAE017.trim();
		}
	}

	@Field("定点医疗机构经办日期")
	String AAE032;

	public String getAAE032() {
		return AAE032;
	}

	public void setAAE032(String aAE032) {
		if ("".equals(aAE032) || aAE032 == null) {
			AAE032 = "无";
		} else {
			AAE032 = aAE032.trim();
		}
	}

	@Field("统筹单独支付金额")
	String BKC060;

	public String getBKC060() {
		return BKC060;
	}

	public void setBKC060(String bKC060) {
		if ("".equals(bKC060) || bKC060 == null) {
			BKC060 = "0";
		} else {
			BKC060 = bKC060.trim();
		}
	}

	@Field("实际自付比例")
	String BKC061;

	public String getBKC061() {
		return BKC061;
	}

	public void setBKC061(String bKC061) {
		if ("".equals(bKC061) || bKC061 == null) {
			BKC061 = "0";
		} else {
			BKC061 = bKC061.trim();
		}
	}

	@Field("统筹自理")
	String BKC062;

	public String getBKC062() {
		return BKC062;
	}

	public void setBKC062(String bKC062) {
		if ("".equals(bKC062) || bKC062 == null) {
			BKC062 = "无";
		} else {
			BKC062 = bKC062.trim();
		}
	}

	@Field("大额自理")
	String BKC063;

	public String getBKC063() {
		return BKC063;
	}

	public void setBKC063(String bKC063) {
		if ("".equals(bKC063) || bKC063 == null) {
			BKC063 = "无";
		} else {
			BKC063 = bKC063.trim();
		}
	}

	@Field("跨段标识")
	String BKC066;

	public String getBKC066() {
		return BKC066;
	}

	public void setBKC066(String bKC066) {
		if ("".equals(bKC066) || bKC066 == null) {
			BKC066 = "无";
		} else {
			BKC066 = bKC066.trim();
		}
	}

	@Field("单独支付项目类型")
	String BKC067;

	public String getBKC067() {
		return BKC067;
	}

	public void setBKC067(String bKC067) {
		if ("".equals(bKC067) || bKC067 == null) {
			BKC067 = "无";
		} else {
			BKC067 = bKC067.trim();
		}
	}

	@Field("基本药物标识")
	String BKC068;

	public String getBKC068() {
		return BKC068;
	}

	public void setBKC068(String bKC068) {
		if ("".equals(bKC068) || bKC068 == null) {
			BKC068 = "无";
		} else {
			BKC068 = bKC068.trim();
		}
	}

	@Field("退费合并处方标识")
	String BKC069;

	public String getBKC069() {
		return BKC069;
	}

	public void setBKC069(String bKC069) {
		if ("".equals(bKC069) || bKC069 == null) {
			BKC069 = "无";
		} else {
			BKC069 = bKC069.trim();
		}
	}

	@Field("BAZ001")
	String BAZ001;

	public String getBAZ001() {
		return BAZ001;
	}

	public void setBAZ001(String bAZ001) {
		if ("".equals(bAZ001) || bAZ001 == null) {
			BAZ001 = "无";
		} else {
			BAZ001 = bAZ001.trim();
		}
	}

	@Field("创建经办人")
	String BZE011;

	public String getBZE011() {
		return BZE011;
	}

	public void setBZE011(String bZE011) {
		if ("".equals(bZE011) || bZE011 == null) {
			BZE011 = "无";
		} else {
			BZE011 = bZE011.trim();
		}
	}

	@Field("创建经办日期")
	String BZE036;

	public String getBZE036() {
		return BZE036;
	}

	public void setBZE036(String bZE036) {
		if ("".equals(bZE036) || bZE036 == null) {
			BZE036 = "无";
		} else {
			BZE036 = bZE036.trim();
		}
	}

	@Field("统筹区号")
	String AAA027;

	public String getAAA027() {
		return AAA027;
	}

	public void setAAA027(String aAA027) {
		if ("".equals(aAA027) || aAA027 == null) {
			AAA027 = "无";
		} else {
			AAA027 = aAA027.trim();
		}
	}

	@Field("社保经办机构编码")
	String AAB034;

	public String getAAB034() {
		return AAB034;
	}

	public void setAAB034(String aAB034) {
		if ("".equals(aAB034) || aAB034 == null) {
			AAB034 = "无";
		} else {
			AAB034 = aAB034.trim();
		}
	}

	@Field("个人电脑编号")
	String AAC001;

	public String getAAC001() {
		return AAC001;
	}

	public void setAAC001(String aAC001) {
		if ("".equals(aAC001) || aAC001 == null) {
			AAC001 = "无";
		} else {
			AAC001 = aAC001.trim();
		}
	}

	@Field("基本医疗保险药品代码")
	String BKB070;

	public String getBKB070() {
		return BKB070;
	}

	public void setBKB070(String bKB070) {
		if ("".equals(bKB070) || bKB070 == null) {
			BKB070 = "无";
		} else {
			BKB070 = bKB070.trim();
		}
	}

	@Field("药品普通限制标志")
	String BKC078;

	public String getBKC078() {
		return BKC078;
	}

	public void setBKC078(String bKC078) {
		if ("".equals(bKC078) || bKC078 == null) {
			BKC078 = "无";
		} else {
			BKC078 = bKC078.trim();
		}
	}

	@Field("药品特殊限制标志")
	String BKC079;

	public String getBKC079() {
		return BKC079;
	}

	public void setBKC079(String bKC079) {
		if ("".equals(bKC079) || bKC079 == null) {
			BKC079 = "无";
		} else {
			BKC079 = bKC079.trim();
		}
	}

	@Field("超大额封顶以上乙类自理")
	String BKC081;

	public String getBKC081() {
		return BKC081;
	}

	public void setBKC081(String bKC081) {
		if ("".equals(bKC081) || bKC081 == null) {
			BKC081 = "无";
		} else {
			BKC081 = bKC081.trim();
		}
	}

	@Field("体检套餐打折比例")
	String BKA971;

	public String getBKA971() {
		return BKA971;
	}

	public void setBKA971(String bKA971) {
		if ("".equals(bKA971) || bKA971 == null) {
			BKA971 = "0";
		} else {
			BKA971 = bKA971.trim();
		}
	}

	@Field("诊疗项目部位码")
	String BKA973;

	public String getBKA973() {
		return BKA973;
	}

	public void setBKA973(String bKA973) {
		if ("".equals(bKA973) || bKA973 == null) {
			BKA973 = "无";
		} else {
			BKA973 = bKA973.trim();
		}
	}

	@Field("诊疗项目控制标识")
	String BKA974;

	public String getBKA974() {
		return BKA974;
	}

	public void setBKA974(String bKA974) {
		if ("".equals(bKA974) || bKA974 == null) {
			BKA974 = "无";
		} else {
			BKA974 = bKA974.trim();
		}
	}

	@Field
	private String owner;
	@Field
	private String content_level;

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

}
