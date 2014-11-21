package net.wonderslife.indexer.expense;

import org.apache.solr.client.solrj.beans.Field;

public class Expense {
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

	@Field("参保组织编号")
	String AAB001;

	public String getAAB001() {
		return AAB001;
	}

	public void setAAB001(String aAB001) {
		if ("".equals(aAB001) || aAB001 == null) {
			AAB001 = "0";
		} else {
			AAB001 = aAB001.trim();
		}
	}

	@Field("单位名称")
	String AAB004;

	public String getAAB004() {
		return AAB004;
	}

	public void setAAB004(String aAB004) {
		if ("".equals(aAB004) || aAB004 == null) {
			AAB004 = "无";
		} else {
			AAB004 = aAB004.trim();
		}
	}

	@Field("单位类型")
	String AAB019;

	public String getAAB019() {
		return AAB019;
	}

	public void setAAB019(String aAB019) {
		if ("".equals(aAB019) || aAB019 == null) {
			AAB019 = "无";
		} else {
			AAB019 = aAB019.trim();
		}
	}

	@Field("经济类型")
	String AAB020;

	public String getAAB020() {
		return AAB020;
	}

	public void setAAB020(String aAB020) {
		if ("".equals(aAB020) || aAB020 == null) {
			AAB020 = "无";
		} else {
			AAB020 = aAB020.trim();
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

	@Field("单位编号")
	String AAB999;

	public String getAAB999() {
		return AAB999;
	}

	public void setAAB999(String aAB999) {
		if ("".equals(aAB999) || aAB999 == null) {
			AAB999 = "无";
		} else {
			AAB999 = aAB999.trim();
		}
	}

	@Field("个人编号")
	String AAC001;

	public String getAAC001() {
		return AAC001;
	}

	public void setAAC001(String aAC001) {
		if ("".equals(aAC001) || aAC001 == null) {
			AAC001 = "0";
		} else {
			AAC001 = aAC001.trim();
		}
	}

	@Field("姓名")
	String AAC003;

	public String getAAC003() {
		return AAC003;
	}

	public void setAAC003(String aAC003) {
		if ("".equals(aAC003) || aAC003 == null) {
			AAC003 = "无";
		} else {
			AAC003 = aAC003.trim();
		}
	}

	@Field("个人管理码")
	String AAC999;

	public String getAAC999() {
		return AAC999;
	}

	public void setAAC999(String aAC999) {
		if ("".equals(aAC999) || aAC999 == null) {
			AAC999 = "无";
		} else {
			AAC999 = aAC999.trim();
		}
	}

	@Field("结算年度")
	String AAE001;

	public String getAAE001() {
		return AAE001;
	}

	public void setAAE001(String aAE001) {
		if ("".equals(aAE001) || aAE001 == null) {
			AAE001 = "0";
		} else {
			AAE001 = aAE001.trim();
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

	@Field("医院经办人")
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

	@Field("医院经办日期")
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

	@Field("财务接口流水号")
	String AAE076;

	public String getAAE076() {
		return AAE076;
	}

	public void setAAE076(String aAE076) {
		if ("".equals(aAE076) || aAE076 == null) {
			AAE076 = "0";
		} else {
			AAE076 = aAE076.trim();
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

	@Field("支付状态")
	String AAE117;

	public String getAAE117() {
		return AAE117;
	}

	public void setAAE117(String aAE117) {
		if ("".equals(aAE117) || aAE117 == null) {
			AAE117 = "无";
		} else {
			AAE117 = aAE117.trim();
		}
	}

	@Field("公民身份号码")
	String AAE135;

	public String getAAE135() {
		return AAE135;
	}

	public void setAAE135(String aAE135) {
		if ("".equals(aAE135) || aAE135 == null) {
			AAE135 = "无";
		} else {
			AAE135 = aAE135.trim();
		}
	}

	@Field("主险种类型")
	String AAE140;

	public String getAAE140() {
		return AAE140;
	}

	public void setAAE140(String aAE140) {
		if ("".equals(aAE140) || aAE140 == null) {
			AAE140 = "无";
		} else {
			AAE140 = aAE140.trim();
		}
	}

	@Field("社保卡号")
	String AAZ500;

	public String getAAZ500() {
		return AAZ500;
	}

	public void setAAZ500(String aAZ500) {
		if ("".equals(aAZ500) || aAZ500 == null) {
			AAZ500 = "无";
		} else {
			AAZ500 = aAZ500.trim();
		}
	}

	@Field("医院等级")
	String AKA101;

	public String getAKA101() {
		return AKA101;
	}

	public void setAKA101(String aKA101) {
		if ("".equals(aKA101) || aKA101 == null) {
			AKA101 = "无";
		} else {
			AKA101 = aKA101.trim();
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

	@Field("医疗人员类别")
	String AKC021;

	public String getAKC021() {
		return AKC021;
	}

	public void setAKC021(String aKC021) {
		if ("".equals(aKC021) || aKC021 == null) {
			AKC021 = "无";
		} else {
			AKC021 = aKC021.trim();
		}
	}

	@Field("本次就医之前账户余额")
	String AKC087;

	public String getAKC087() {
		return AKC087;
	}

	public void setAKC087(String aKC087) {
		if ("".equals(aKC087) || aKC087 == null) {
			AKC087 = "0";
		} else {
			AKC087 = aKC087.trim();
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

	@Field("帐户冲减日期")
	String AKC266;

	public String getAKC266() {
		return AKC266;
	}

	public void setAKC266(String aKC266) {
		if ("".equals(aKC266) || aKC266 == null) {
			AKC266 = "无";
		} else {
			AKC266 = aKC266.trim();
		}
	}

	@Field("帐户冲减标志")
	String AKC267;

	public String getAKC267() {
		return AKC267;
	}

	public void setAKC267(String aKC267) {
		if ("".equals(aKC267) || aKC267 == null) {
			AKC267 = "无";
		} else {
			AKC267 = aKC267.trim();
		}
	}

	@Field("结算日期")
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

	@Field("医疗险种串")
	String BAA084;

	public String getBAA084() {
		return BAA084;
	}

	public void setBAA084(String bAA084) {
		if ("".equals(bAA084) || bAA084 == null) {
			BAA084 = "无";
		} else {
			BAA084 = bAA084.trim();
		}
	}

	@Field("跨年报销标志")
	String BAC202;

	public String getBAC202() {
		return BAC202;
	}

	public void setBAC202(String bAC202) {
		if ("".equals(bAC202) || bAC202 == null) {
			BAC202 = "无";
		} else {
			BAC202 = bAC202.trim();
		}
	}

	@Field("支付人")
	String BAD533;

	public String getBAD533() {
		return BAD533;
	}

	public void setBAD533(String bAD533) {
		if ("".equals(bAD533) || bAD533 == null) {
			BAD533 = "无";
		} else {
			BAD533 = bAD533.trim();
		}
	}

	@Field("支付日期")
	String BAD534;

	public String getBAD534() {
		return BAD534;
	}

	public void setBAD534(String bAD534) {
		if ("".equals(bAD534) || bAD534 == null) {
			BAD534 = "无";
		} else {
			BAD534 = bAD534.trim();
		}
	}

	@Field("送银行经办人")
	String BAD536;

	public String getBAD536() {
		return BAD536;
	}

	public void setBAD536(String bAD536) {
		if ("".equals(bAD536) || bAD536 == null) {
			BAD536 = "无";
		} else {
			BAD536 = bAD536.trim();
		}
	}

	@Field("送银行经办日期")
	String BAD537;

	public String getBAD537() {
		return BAD537;
	}

	public void setBAD537(String bAD537) {
		if ("".equals(bAD537) || bAD537 == null) {
			BAD537 = "无";
		} else {
			BAD537 = bAD537.trim();
		}
	}

	@Field("支出流水号")
	String BAE074;

	public String getBAE074() {
		return BAE074;
	}

	public void setBAE074(String bAE074) {
		if ("".equals(bAE074) || bAE074 == null) {
			BAE074 = "0";
		} else {
			BAE074 = bAE074.trim();
		}
	}

	@Field
	String BAZ001;

	public String getBAZ001() {
		return BAZ001;
	}

	public void setBAZ001(String bAZ001) {
		if ("".equals(bAZ001) || bAZ001 == null) {
			BAZ001 = "0";
		} else {
			BAZ001 = bAZ001.trim();
		}
	}

	@Field("操作序号")
	String BAZ002;

	public String getBAZ002() {
		return BAZ002;
	}

	public void setBAZ002(String bAZ002) {
		if ("".equals(bAZ002) || bAZ002 == null) {
			BAZ002 = "0";
		} else {
			BAZ002 = bAZ002.trim();
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

	@Field("动态库版本号")
	String BKA203;

	public String getBKA203() {
		return BKA203;
	}

	public void setBKA203(String bKA203) {
		if ("".equals(bKA203) || bKA203 == null) {
			BKA203 = "无";
		} else {
			BKA203 = bKA203.trim();
		}
	}

	@Field("单据打印次数")
	String BKA627;

	public String getBKA627() {
		return BKA627;
	}

	public void setBKA627(String bKA627) {
		if ("".equals(bKA627) || bKA627 == null) {
			BKA627 = "无";
		} else {
			BKA627 = bKA627.trim();
		}
	}

	@Field("特病分类")
	String BKA628;

	public String getBKA628() {
		return BKA628;
	}

	public void setBKA628(String bKA628) {
		if ("".equals(bKA628) || bKA628 == null) {
			BKA628 = "无";
		} else {
			BKA628 = bKA628.trim();
		}
	}

	@Field("允许取消结算标志")
	String BKA630;

	public String getBKA630() {
		return BKA630;
	}

	public void setBKA630(String bKA630) {
		if ("".equals(bKA630) || bKA630 == null) {
			BKA630 = "无";
		} else {
			BKA630 = bKA630.trim();
		}
	}

	@Field("月结流水号")
	String BKB030;

	public String getBKB030() {
		return BKB030;
	}

	public void setBKB030(String bKB030) {
		if ("".equals(bKB030) || bKB030 == null) {
			BKB030 = "0";
		} else {
			BKB030 = bKB030.trim();
		}
	}

	@Field("报财务经办人员")
	String BKC012;

	public String getBKC012() {
		return BKC012;
	}

	public void setBKC012(String bKC012) {
		if ("".equals(bKC012) || bKC012 == null) {
			BKC012 = "无";
		} else {
			BKC012 = bKC012.trim();
		}
	}

	@Field("报财务日期")
	String BKC013;

	public String getBKC013() {
		return BKC013;
	}

	public void setBKC013(String bKC013) {
		if ("".equals(bKC013) || bKC013 == null) {
			BKC013 = "无";
		} else {
			BKC013 = bKC013.trim();
		}
	}

	@Field("统筹支付")
	String BKC014;

	public String getBKC014() {
		return BKC014;
	}

	public void setBKC014(String bKC014) {
		if ("".equals(bKC014) || bKC014 == null) {
			BKC014 = "0";
		} else {
			BKC014 = bKC014.trim();
		}
	}

	@Field("大额支付")
	String BKC015;

	public String getBKC015() {
		return BKC015;
	}

	public void setBKC015(String bKC015) {
		if ("".equals(bKC015) || bKC015 == null) {
			BKC015 = "0";
		} else {
			BKC015 = bKC015.trim();
		}
	}

	@Field("月结算日期")
	String BKC016;

	public String getBKC016() {
		return BKC016;
	}

	public void setBKC016(String bKC016) {
		if ("".equals(bKC016) || bKC016 == null) {
			BKC016 = "无";
		} else {
			BKC016 = bKC016.trim();
		}
	}

	@Field("零星报销可打印标识")
	String BKC018;

	public String getBKC018() {
		return BKC018;
	}

	public void setBKC018(String bKC018) {
		if ("".equals(bKC018) || bKC018 == null) {
			BKC018 = "无";
		} else {
			BKC018 = bKC018.trim();
		}
	}

	@Field("零星报销打印时间")
	String BKC019;

	public String getBKC019() {
		return BKC019;
	}

	public void setBKC019(String bKC019) {
		if ("".equals(bKC019) || bKC019 == null) {
			BKC019 = "无";
		} else {
			BKC019 = bKC019.trim();
		}
	}

	@Field("医疗待遇类别")
	String BKC021;

	public String getBKC021() {
		return BKC021;
	}

	public void setBKC021(String bKC021) {
		if ("".equals(bKC021) || bKC021 == null) {
			BKC021 = "无";
		} else {
			BKC021 = bKC021.trim();
		}
	}

	@Field("统筹实际支付(月结算)")
	String BKC070;

	public String getBKC070() {
		return BKC070;
	}

	public void setBKC070(String bKC070) {
		if ("".equals(bKC070) || bKC070 == null) {
			BKC070 = "0";
		} else {
			BKC070 = bKC070.trim();
		}
	}

	@Field("大额实际支付(月结算)")
	String BKC071;

	public String getBKC071() {
		return BKC071;
	}

	public void setBKC071(String bKC071) {
		if ("".equals(bKC071) || bKC071 == null) {
			BKC071 = "0";
		} else {
			BKC071 = bKC071.trim();
		}
	}

	@Field("预留金(月结算)")
	String BKC072;

	public String getBKC072() {
		return BKC072;
	}

	public void setBKC072(String bKC072) {
		if ("".equals(bKC072) || bKC072 == null) {
			BKC072 = "0";
		} else {
			BKC072 = bKC072.trim();
		}
	}

	@Field("医师违规标志")
	String BKC073;

	public String getBKC073() {
		return BKC073;
	}

	public void setBKC073(String bKC073) {
		if ("".equals(bKC073) || bKC073 == null) {
			BKC073 = "无";
		} else {
			BKC073 = bKC073.trim();
		}
	}

	@Field("审核状态(医师审核)")
	String BKC074;

	public String getBKC074() {
		return BKC074;
	}

	public void setBKC074(String bKC074) {
		if ("".equals(bKC074) || bKC074 == null) {
			BKC074 = "无";
		} else {
			BKC074 = bKC074.trim();
		}
	}

	@Field("单独支付项目审核状态")
	String BKC075;

	public String getBKC075() {
		return BKC075;
	}

	public void setBKC075(String bKC075) {
		if ("".equals(bKC075) || bKC075 == null) {
			BKC075 = "无";
		} else {
			BKC075 = bKC075.trim();
		}
	}

	@Field("是否初审复审标志")
	String BKC076;

	public String getBKC076() {
		return BKC076;
	}

	public void setBKC076(String bKC076) {
		if ("".equals(bKC076) || bKC076 == null) {
			BKC076 = "无";
		} else {
			BKC076 = bKC076.trim();
		}
	}

	@Field("月结算标识")
	String BKC077;

	public String getBKC077() {
		return BKC077;
	}

	public void setBKC077(String bKC077) {
		if ("".equals(bKC077) || bKC077 == null) {
			BKC077 = "无";
		} else {
			BKC077 = bKC077.trim();
		}
	}

	@Field("单独支付项目类型")
	String BKC091;

	public String getBKC091() {
		return BKC091;
	}

	public void setBKC091(String bKC091) {
		if ("".equals(bKC091) || bKC091 == null) {
			BKC091 = "无";
		} else {
			BKC091 = bKC091.trim();
		}
	}

	@Field("修改原因(医师审核)")
	String BKC092;

	public String getBKC092() {
		return BKC092;
	}

	public void setBKC092(String bKC092) {
		if ("".equals(bKC092) || bKC092 == null) {
			BKC092 = "无";
		} else {
			BKC092 = bKC092.trim();
		}
	}

	@Field("统筹单独支付项目实际支付")
	String BKC093;

	public String getBKC093() {
		return BKC093;
	}

	public void setBKC093(String bKC093) {
		if ("".equals(bKC093) || bKC093 == null) {
			BKC093 = "0";
		} else {
			BKC093 = bKC093.trim();
		}
	}

	@Field("联脱机标志")
	String BKC120;

	public String getBKC120() {
		return BKC120;
	}

	public void setBKC120(String bKC120) {
		if ("".equals(bKC120) || bKC120 == null) {
			BKC120 = "无";
		} else {
			BKC120 = bKC120.trim();
		}
	}

	@Field("合并住院号（门诊号）")
	String BKC190;

	public String getBKC190() {
		return BKC190;
	}

	public void setBKC190(String bKC190) {
		if ("".equals(bKC190) || bKC190 == null) {
			BKC190 = "无";
		} else {
			BKC190 = bKC190.trim();
		}
	}

	@Field("报销标志")
	String BKC197;

	public String getBKC197() {
		return BKC197;
	}

	public void setBKC197(String bKC197) {
		if ("".equals(bKC197) || bKC197 == null) {
			BKC197 = "无";
		} else {
			BKC197 = bKC197.trim();
		}
	}

	@Field("前次是否有中途结算")
	String BKC198;

	public String getBKC198() {
		return BKC198;
	}

	public void setBKC198(String bKC198) {
		if ("".equals(bKC198) || bKC198 == null) {
			BKC198 = "无";
		} else {
			BKC198 = bKC198.trim();
		}
	}

	@Field("连续住院标志")
	String BKC199;

	public String getBKC199() {
		return BKC199;
	}

	public void setBKC199(String bKC199) {
		if ("".equals(bKC199) || bKC199 == null) {
			BKC199 = "无";
		} else {
			BKC199 = bKC199.trim();
		}
	}

	@Field("中途结算标志")
	String BKC200;

	public String getBKC200() {
		return BKC200;
	}

	public void setBKC200(String bKC200) {
		if ("".equals(bKC200) || bKC200 == null) {
			BKC200 = "无";
		} else {
			BKC200 = bKC200.trim();
		}
	}

	@Field("卡行计数")
	String BKC201;

	public String getBKC201() {
		return BKC201;
	}

	public void setBKC201(String bKC201) {
		if ("".equals(bKC201) || bKC201 == null) {
			BKC201 = "0";
		} else {
			BKC201 = bKC201.trim();
		}
	}

	@Field("欠费结算标志")
	String BKC203;

	public String getBKC203() {
		return BKC203;
	}

	public void setBKC203(String bKC203) {
		if ("".equals(bKC203) || bKC203 == null) {
			BKC203 = "无";
		} else {
			BKC203 = bKC203.trim();
		}
	}

	@Field("跨月退费标志")
	String BKC204;

	public String getBKC204() {
		return BKC204;
	}

	public void setBKC204(String bKC204) {
		if ("".equals(bKC204) || bKC204 == null) {
			BKC204 = "无";
		} else {
			BKC204 = bKC204.trim();
		}
	}

	@Field("二次报销标志")
	String BKC205;

	public String getBKC205() {
		return BKC205;
	}

	public void setBKC205(String bKC205) {
		if ("".equals(bKC205) || bKC205 == null) {
			BKC205 = "无";
		} else {
			BKC205 = bKC205.trim();
		}
	}

	@Field("传输标志")
	String BKC319;

	public String getBKC319() {
		return BKC319;
	}

	public void setBKC319(String bKC319) {
		if ("".equals(bKC319) || bKC319 == null) {
			BKC319 = "无";
		} else {
			BKC319 = bKC319.trim();
		}
	}

	@Field("审核状态")
	String BKC328;

	public String getBKC328() {
		return BKC328;
	}

	public void setBKC328(String bKC328) {
		if ("".equals(bKC328) || bKC328 == null) {
			BKC328 = "无";
		} else {
			BKC328 = bKC328.trim();
		}
	}

	@Field("帐户支付标志")
	String BKC329;

	public String getBKC329() {
		return BKC329;
	}

	public void setBKC329(String bKC329) {
		if ("".equals(bKC329) || bKC329 == null) {
			BKC329 = "无";
		} else {
			BKC329 = bKC329.trim();
		}
	}

	@Field("本次结算对应月结算人次")
	String BKC335;

	public String getBKC335() {
		return BKC335;
	}

	public void setBKC335(String bKC335) {
		if ("".equals(bKC335) || bKC335 == null) {
			BKC335 = "0";
		} else {
			BKC335 = bKC335.trim();
		}
	}

	@Field("业务周期号")
	String BKC376;

	public String getBKC376() {
		return BKC376;
	}

	public void setBKC376(String bKC376) {
		if ("".equals(bKC376) || bKC376 == null) {
			BKC376 = "无";
		} else {
			BKC376 = bKC376.trim();
		}
	}

	@Field("撤消业务周期号")
	String BKC377;

	public String getBKC377() {
		return BKC377;
	}

	public void setBKC377(String bKC377) {
		if ("".equals(bKC377) || bKC377 == null) {
			BKC377 = "无";
		} else {
			BKC377 = bKC377.trim();
		}
	}

	@Field("发送方交易流水号")
	String BKC378;

	public String getBKC378() {
		return BKC378;
	}

	public void setBKC378(String bKC378) {
		if ("".equals(bKC378) || bKC378 == null) {
			BKC378 = "无";
		} else {
			BKC378 = bKC378.trim();
		}
	}

	@Field("接收方交易流水号")
	String BKC379;

	public String getBKC379() {
		return BKC379;
	}

	public void setBKC379(String bKC379) {
		if ("".equals(bKC379) || bKC379 == null) {
			BKC379 = "无";
		} else {
			BKC379 = bKC379.trim();
		}
	}

	@Field("发送方被撤销交易流水号")
	String BKC380;

	public String getBKC380() {
		return BKC380;
	}

	public void setBKC380(String bKC380) {
		if ("".equals(bKC380) || bKC380 == null) {
			BKC380 = "无";
		} else {
			BKC380 = bKC380.trim();
		}
	}

	@Field("接收方被撤销交易流水号")
	String BKC381;

	public String getBKC381() {
		return BKC381;
	}

	public void setBKC381(String bKC381) {
		if ("".equals(bKC381) || bKC381 == null) {
			BKC381 = "无";
		} else {
			BKC381 = bKC381.trim();
		}
	}

	@Field("支付方式")
	String BKC401;

	public String getBKC401() {
		return BKC401;
	}

	public void setBKC401(String bKC401) {
		if ("".equals(bKC401) || bKC401 == null) {
			BKC401 = "无";
		} else {
			BKC401 = bKC401.trim();
		}
	}

	@Field("支付对象")
	String BKC403;

	public String getBKC403() {
		return BKC403;
	}

	public void setBKC403(String bKC403) {
		if ("".equals(bKC403) || bKC403 == null) {
			BKC403 = "无";
		} else {
			BKC403 = bKC403.trim();
		}
	}

	@Field("住院床日")
	String BKE001;

	public String getBKE001() {
		return BKE001;
	}

	public void setBKE001(String bKE001) {
		if ("".equals(bKE001) || bKE001 == null) {
			BKE001 = "0";
		} else {
			BKE001 = bKE001.trim();
		}
	}

	@Field("数据状态")
	String BKE022;

	public String getBKE022() {
		return BKE022;
	}

	public void setBKE022(String bKE022) {
		if ("".equals(bKE022) || bKE022 == null) {
			BKE022 = "无";
		} else {
			BKE022 = bKE022.trim();
		}
	}

	@Field("复核结果")
	String BKE160;

	public String getBKE160() {
		return BKE160;
	}

	public void setBKE160(String bKE160) {
		if ("".equals(bKE160) || bKE160 == null) {
			BKE160 = "无";
		} else {
			BKE160 = bKE160.trim();
		}
	}

	@Field("复核人")
	String BKE161;

	public String getBKE161() {
		return BKE161;
	}

	public void setBKE161(String bKE161) {
		if ("".equals(bKE161) || bKE161 == null) {
			BKE161 = "无";
		} else {
			BKE161 = bKE161.trim();
		}
	}

	@Field("复核日期")
	String BKE162;

	public String getBKE162() {
		return BKE162;
	}

	public void setBKE162(String bKE162) {
		if ("".equals(bKE162) || bKE162 == null) {
			BKE162 = "无";
		} else {
			BKE162 = bKE162.trim();
		}
	}

	@Field("开发商标志")
	String BKF100;

	public String getBKF100() {
		return BKF100;
	}

	public void setBKF100(String bKF100) {
		if ("".equals(bKF100) || bKF100 == null) {
			BKF100 = "无";
		} else {
			BKF100 = bKF100.trim();
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
