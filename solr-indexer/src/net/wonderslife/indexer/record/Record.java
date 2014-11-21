package net.wonderslife.indexer.record;

import org.apache.solr.client.solrj.beans.Field;

public class Record {
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

	@Field("异地行政区划")
	String AAB301;

	public String getAAB301() {
		return AAB301;
	}

	public void setAAB301(String aAB301) {
		if ("".equals(aAB301) || aAB301 == null) {
			AAB301 = "无";
		} else {
			AAB301 = aAB301.trim();
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

	@Field("性别")
	String AAC004;

	public String getAAC004() {
		return AAC004;
	}

	public void setAAC004(String aAC004) {
		if ("".equals(aAC004) || aAC004 == null) {
			AAC004 = "无";
		} else {
			AAC004 = aAC004.trim();
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

	@Field("银行户名")
	String AAE009;

	public String getAAE009() {
		return AAE009;
	}

	public void setAAE009(String aAE009) {
		if ("".equals(aAE009) || aAE009 == null) {
			AAE009 = "无";
		} else {
			AAE009 = aAE009.trim();
		}
	}

	@Field("银行账号")
	String AAE010;

	public String getAAE010() {
		return AAE010;
	}

	public void setAAE010(String aAE010) {
		if ("".equals(aAE010) || aAE010 == null) {
			AAE010 = "无";
		} else {
			AAE010 = aAE010.trim();
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

	@Field("备注")
	String AAE013;

	public String getAAE013() {
		return AAE013;
	}

	public void setAAE013(String aAE013) {
		if ("".equals(aAE013) || aAE013 == null) {
			AAE013 = "无";
		} else {
			AAE013 = aAE013.trim();
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

	@Field("一般起付标准")
	String AKA151;

	public String getAKA151() {
		return AKA151;
	}

	public void setAKA151(String aKA151) {
		if ("".equals(aKA151) || aKA151 == null) {
			AKA151 = "0";
		} else {
			AKA151 = aKA151.trim();
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

	@Field("定点医疗机构名称")
	String AKB021;

	public String getAKB021() {
		return AKB021;
	}

	public void setAKB021(String aKB021) {
		if ("".equals(aKB021) || aKB021 == null) {
			AKB021 = "无";
		} else {
			AKB021 = aKB021.trim();
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

	@Field("入院诊断疾病编码主码")
	String AKC193;

	public String getAKC193() {
		return AKC193;
	}

	public void setAKC193(String aKC193) {
		if ("".equals(aKC193) || aKC193 == null) {
			AKC193 = "无";
		} else {
			AKC193 = aKC193.trim();
		}
	}

	@Field("出院原因")
	String AKC195;

	public String getAKC195() {
		return AKC195;
	}

	public void setAKC195(String aKC195) {
		if ("".equals(aKC195) || aKC195 == null) {
			AKC195 = "无";
		} else {
			AKC195 = aKC195.trim();
		}
	}

	@Field("出院诊断疾病编码主码")
	String AKC196;

	public String getAKC196() {
		return AKC196;
	}

	public void setAKC196(String aKC196) {
		if ("".equals(aKC196) || aKC196 == null) {
			AKC196 = "无";
		} else {
			AKC196 = aKC196.trim();
		}
	}

	@Field("主治医师姓名")
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

	@Field("报销原因")
	String AKE013;

	public String getAKE013() {
		return AKE013;
	}

	public void setAKE013(String aKE013) {
		if ("".equals(aKE013) || aKE013 == null) {
			AKE013 = "无";
		} else {
			AKE013 = aKE013.trim();
		}
	}

	@Field("床位号")
	String AKE020;

	public String getAKE020() {
		return AKE020;
	}

	public void setAKE020(String aKE020) {
		if ("".equals(aKE020) || aKE020 == null) {
			AKE020 = "无";
		} else {
			AKE020 = aKE020.trim();
		}
	}

	@Field("病区")
	String AKE021;

	public String getAKE021() {
		return AKE021;
	}

	public void setAKE021(String aKE021) {
		if ("".equals(aKE021) || aKE021 == null) {
			AKE021 = "无";
		} else {
			AKE021 = aKE021.trim();
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

	@Field("计划生育手术或生育日期")
	String AMC020;

	public String getAMC020() {
		return AMC020;
	}

	public void setAMC020(String aMC020) {
		if ("".equals(aMC020) || aMC020 == null) {
			AMC020 = "无";
		} else {
			AMC020 = aMC020.trim();
		}
	}

	@Field("银行名称")
	String BAB024;

	public String getBAB024() {
		return BAB024;
	}

	public void setBAB024(String bAB024) {
		if ("".equals(bAB024) || bAB024 == null) {
			BAB024 = "无";
		} else {
			BAB024 = bAB024.trim();
		}
	}

	@Field("异地个人编号")
	String BAC888;

	public String getBAC888() {
		return BAC888;
	}

	public void setBAC888(String bAC888) {
		if ("".equals(bAC888) || bAC888 == null) {
			BAC888 = "无";
		} else {
			BAC888 = bAC888.trim();
		}
	}

	@Field("出院备注")
	String BAE013;

	public String getBAE013() {
		return BAE013;
	}

	public void setBAE013(String bAE013) {
		if ("".equals(bAE013) || bAE013 == null) {
			BAE013 = "无";
		} else {
			BAE013 = bAE013.trim();
		}
	}

	@Field("审批编号")
	String BAE073;

	public String getBAE073() {
		return BAE073;
	}

	public void setBAE073(String bAE073) {
		if ("".equals(bAE073) || bAE073 == null) {
			BAE073 = "无";
		} else {
			BAE073 = bAE073.trim();
		}
	}

	@Field("年龄")
	String BAE450;

	public String getBAE450() {
		return BAE450;
	}

	public void setBAE450(String bAE450) {
		if ("".equals(bAE450) || bAE450 == null) {
			BAE450 = "0";
		} else {
			BAE450 = bAE450.trim();
		}
	}

	@Field("BAZ001")
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

	@Field("区别异地联网结算交易和普通异地就医")
	String BKA130;

	public String getBKA130() {
		return BKA130;
	}

	public void setBKA130(String bKA130) {
		if ("".equals(bKA130) || bKA130 == null) {
			BKA130 = "无";
		} else {
			BKA130 = bKA130.trim();
		}
	}

	@Field("医疗机构类别")
	String BKB010;

	public String getBKB010() {
		return BKB010;
	}

	public void setBKB010(String bKB010) {
		if ("".equals(bKB010) || bKB010 == null) {
			BKB010 = "无";
		} else {
			BKB010 = bKB010.trim();
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

	@Field("异地就诊原因")
	String BKC023;

	public String getBKC023() {
		return BKC023;
	}

	public void setBKC023(String bKC023) {
		if ("".equals(bKC023) || bKC023 == null) {
			BKC023 = "无";
		} else {
			BKC023 = bKC023.trim();
		}
	}

	@Field("勘错标识")
	String BKC050;

	public String getBKC050() {
		return BKC050;
	}

	public void setBKC050(String bKC050) {
		if ("".equals(bKC050) || bKC050 == null) {
			BKC050 = "无";
		} else {
			BKC050 = bKC050.trim();
		}
	}

	@Field("预约挂号标志")
	String BKC051;

	public String getBKC051() {
		return BKC051;
	}

	public void setBKC051(String bKC051) {
		if ("".equals(bKC051) || bKC051 == null) {
			BKC051 = "无";
		} else {
			BKC051 = bKC051.trim();
		}
	}

	@Field("入院疾病识别码")
	String BKC052;

	public String getBKC052() {
		return BKC052;
	}

	public void setBKC052(String bKC052) {
		if ("".equals(bKC052) || bKC052 == null) {
			BKC052 = "无";
		} else {
			BKC052 = bKC052.trim();
		}
	}

	@Field("出院疾病识别码")
	String BKC053;

	public String getBKC053() {
		return BKC053;
	}

	public void setBKC053(String bKC053) {
		if ("".equals(bKC053) || bKC053 == null) {
			BKC053 = "无";
		} else {
			BKC053 = bKC053.trim();
		}
	}

	@Field("勘错前出院识别码")
	String BKC054;

	public String getBKC054() {
		return BKC054;
	}

	public void setBKC054(String bKC054) {
		if ("".equals(bKC054) || bKC054 == null) {
			BKC054 = "无";
		} else {
			BKC054 = bKC054.trim();
		}
	}

	@Field("生育结算标识字段")
	String BKC055;

	public String getBKC055() {
		return BKC055;
	}

	public void setBKC055(String bKC055) {
		if ("".equals(bKC055) || bKC055 == null) {
			BKC055 = "无";
		} else {
			BKC055 = bKC055.trim();
		}
	}

	@Field("费用来源")
	String BKC056;

	public String getBKC056() {
		return BKC056;
	}

	public void setBKC056(String bKC056) {
		if ("".equals(bKC056) || bKC056 == null) {
			BKC056 = "无";
		} else {
			BKC056 = bKC056.trim();
		}
	}

	@Field("电子病历标志")
	String BKC057;

	public String getBKC057() {
		return BKC057;
	}

	public void setBKC057(String bKC057) {
		if ("".equals(bKC057) || bKC057 == null) {
			BKC057 = "无";
		} else {
			BKC057 = bKC057.trim();
		}
	}

	@Field("单据录入流水号(报销使用)")
	String BKC058;

	public String getBKC058() {
		return BKC058;
	}

	public void setBKC058(String bKC058) {
		if ("".equals(bKC058) || bKC058 == null) {
			BKC058 = "无";
		} else {
			BKC058 = bKC058.trim();
		}
	}

	@Field("病种识别码")
	String BKC059;

	public String getBKC059() {
		return BKC059;
	}

	public void setBKC059(String bKC059) {
		if ("".equals(bKC059) || bKC059 == null) {
			BKC059 = "无";
		} else {
			BKC059 = bKC059.trim();
		}
	}

	@Field("起付标准自付金额")
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

	@Field("中心报销结算标志")
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

	@Field("连续住院标志")
	String BKC128;

	public String getBKC128() {
		return BKC128;
	}

	public void setBKC128(String bKC128) {
		if ("".equals(bKC128) || bKC128 == null) {
			BKC128 = "无";
		} else {
			BKC128 = bKC128.trim();
		}
	}

	@Field("上次住院流水号")
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

	@Field("入院日期")
	String BKC192;

	public String getBKC192() {
		return BKC192;
	}

	public void setBKC192(String bKC192) {
		if ("".equals(bKC192) || bKC192 == null) {
			BKC192 = "无";
		} else {
			BKC192 = bKC192.trim();
		}
	}

	@Field("出院日期")
	String BKC194;

	public String getBKC194() {
		return BKC194;
	}

	public void setBKC194(String bKC194) {
		if ("".equals(bKC194) || bKC194 == null) {
			BKC194 = "无";
		} else {
			BKC194 = bKC194.trim();
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

	@Field("入院诊断疾病名称")
	String BKC231;

	public String getBKC231() {
		return BKC231;
	}

	public void setBKC231(String bKC231) {
		if ("".equals(bKC231) || bKC231 == null) {
			BKC231 = "无";
		} else {
			BKC231 = bKC231.trim();
		}
	}

	@Field("出院诊断疾病名称")
	String BKC232;

	public String getBKC232() {
		return BKC232;
	}

	public void setBKC232(String bKC232) {
		if ("".equals(bKC232) || bKC232 == null) {
			BKC232 = "无";
		} else {
			BKC232 = bKC232.trim();
		}
	}

	@Field("个人卡信息")
	String BKC233;

	public String getBKC233() {
		return BKC233;
	}

	public void setBKC233(String bKC233) {
		if ("".equals(bKC233) || bKC233 == null) {
			BKC233 = "无";
		} else {
			BKC233 = bKC233.trim();
		}
	}

	@Field("报销审核单号")
	String BKC280;

	public String getBKC280() {
		return BKC280;
	}

	public void setBKC280(String bKC280) {
		if ("".equals(bKC280) || bKC280 == null) {
			BKC280 = "无";
		} else {
			BKC280 = bKC280.trim();
		}
	}

	@Field("分院编码")
	String BKC281;

	public String getBKC281() {
		return BKC281;
	}

	public void setBKC281(String bKC281) {
		if ("".equals(bKC281) || bKC281 == null) {
			BKC281 = "无";
		} else {
			BKC281 = bKC281.trim();
		}
	}

	@Field("分院名称")
	String BKC282;

	public String getBKC282() {
		return BKC282;
	}

	public void setBKC282(String bKC282) {
		if ("".equals(bKC282) || bKC282 == null) {
			BKC282 = "无";
		} else {
			BKC282 = bKC282.trim();
		}
	}

	@Field("费用发生地")
	String BKC283;

	public String getBKC283() {
		return BKC283;
	}

	public void setBKC283(String bKC283) {
		if ("".equals(bKC283) || bKC283 == null) {
			BKC283 = "无";
		} else {
			BKC283 = bKC283.trim();
		}
	}

	@Field("本次转出就医审批编号")
	String BKC284;

	public String getBKC284() {
		return BKC284;
	}

	public void setBKC284(String bKC284) {
		if ("".equals(bKC284) || bKC284 == null) {
			BKC284 = "无";
		} else {
			BKC284 = bKC284.trim();
		}
	}

	@Field("出院病种识别码名称")
	String BKC285;

	public String getBKC285() {
		return BKC285;
	}

	public void setBKC285(String bKC285) {
		if ("".equals(bKC285) || bKC285 == null) {
			BKC285 = "无";
		} else {
			BKC285 = bKC285.trim();
		}
	}

	@Field("勘错前病种识别码名称")
	String BKC286;

	public String getBKC286() {
		return BKC286;
	}

	public void setBKC286(String bKC286) {
		if ("".equals(bKC286) || bKC286 == null) {
			BKC286 = "无";
		} else {
			BKC286 = bKC286.trim();
		}
	}

	@Field("出院病种定额")
	String BKC287;

	public String getBKC287() {
		return BKC287;
	}

	public void setBKC287(String bKC287) {
		if ("".equals(bKC287) || bKC287 == null) {
			BKC287 = "无";
		} else {
			BKC287 = bKC287.trim();
		}
	}

	@Field("勘错前病种定额")
	String BKC288;

	public String getBKC288() {
		return BKC288;
	}

	public void setBKC288(String bKC288) {
		if ("".equals(bKC288) || bKC288 == null) {
			BKC288 = "无";
		} else {
			BKC288 = bKC288.trim();
		}
	}

	@Field("勘错金额")
	String BKC289;

	public String getBKC289() {
		return BKC289;
	}

	public void setBKC289(String bKC289) {
		if ("".equals(bKC289) || bKC289 == null) {
			BKC289 = "无";
		} else {
			BKC289 = bKC289.trim();
		}
	}

	//
	@Field("生育费用类别")
	String BKB342;

	public String getBKB342() {
		return BKB342;
	}

	public void setBKB342(String bKC290) {
		if ("".equals(bKC290) || bKC290 == null) {
			BKB342 = "无";
		} else {
			BKB342 = bKC290.trim();
		}
	}

	@Field("在院状态")
	String BKC317;

	public String getBKC317() {
		return BKC317;
	}

	public void setBKC317(String bKC317) {
		if ("".equals(bKC317) || bKC317 == null) {
			BKC317 = "无";
		} else {
			BKC317 = bKC317.trim();
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

	@Field("异地就诊序号")
	String BKC390;

	public String getBKC390() {
		return BKC390;
	}

	public void setBKC390(String bKC390) {
		if ("".equals(bKC390) || bKC390 == null) {
			BKC390 = "无";
		} else {
			BKC390 = bKC390.trim();
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

	@Field("异地结算业务流水号")
	String BKC500;

	public String getBKC500() {
		return BKC500;
	}

	public void setBKC500(String bKC500) {
		if ("".equals(bKC500) || bKC500 == null) {
			BKC500 = "无";
		} else {
			BKC500 = bKC500.trim();
		}
	}

	@Field("复核状态")
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

	@Field("主治医师编码")
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
