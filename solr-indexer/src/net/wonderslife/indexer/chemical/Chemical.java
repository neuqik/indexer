package net.wonderslife.indexer.chemical;

import org.apache.solr.client.solrj.beans.Field;

public class Chemical {
	@Field
	String BAZ001;
	@Field
	String AKA060;
	@Field
	String AKA061;
	@Field
	String AKA062;
	@Field
	String AKA020;
	@Field
	String BKA605;
	@Field("收费类别")
	String AKA063;
	@Field("收费等级")
	String AKA065;
	@Field("剂型")
	String AKA070;
	@Field("规格")
	String AKA074;
	@Field("院内制剂")
	String BKA084;
	@Field
	String AKB020;
	@Field("特药")
	String BKA608;
	@Field
	String AKA109;
	@Field
	String BKA620;
	@Field
	String BKA613;
	@Field("需要审批")
	String BKC173;
	@Field("工伤使用")
	String ALA011;
	@Field("生育使用")
	String AMA011;
	@Field("开始日期")
	String AAE030;
	@Field
	String AAE031;
	@Field("有效")
	String AAE100;
	@Field("备注")
	String AAE013;
	@Field
	String AAA027;
	@Field
	String AAB034;
	@Field("经办人")
	String AAE011;
	@Field
	String AAE036;
	@Field("中心使用")
	String BKA204;
	@Field
	String BKA610;
	@Field
	String BKA083;
	@Field
	String BKA087;
	@Field("基本医疗使用")
	String AKA022;
	@Field
	String BKA638;
	@Field("账户可支付")
	String BKA209;
	@Field("门诊统筹可用")
	String BKA210;
	@Field("药店可使用")
	String BKA217;
	@Field
	String BKA219;
	@Field
	String BKA221;
	@Field
	String BKA222;
	@Field("医保药品剂型")
	String BKA225;
	@Field("国产进口")
	String BKA226;
	@Field("基本药物")
	String BKA228;
	@Field
	String BKA231;
	@Field("医保目录编号")
	String BKA232;
	@Field
	String BKA233;
	@Field
	String BKA234;
	@Field
	String BKA235;
	@Field
	String BKA236;
	@Field
	String BKA237;
	@Field("批准文号")
	String BKA240;
	@Field("一级分类")
	String BKA246;
	@Field("二级分类")
	String BKA247;
	@Field("三级分类")
	String BKA248;
	@Field("四级分类")
	String BKA249;

	public String getBAZ001() {
		return BAZ001;
	}

	public void setBAZ001(String bAZ001) {
		if ("".equals(bAZ001) || bAZ001 == null) {
			BAZ001 = "无";
		} else {
			BAZ001 = bAZ001;
		}
	}

	public String getAKA060() {
		return AKA060;
	}

	public void setAKA060(String aKA060) {
		if ("".equals(aKA060) || aKA060 == null) {
			AKA060 = "无";
		} else {
			AKA060 = aKA060;
		}
	}

	public String getAKA061() {
		return AKA061;
	}

	public void setAKA061(String aKA061) {
		if ("".equals(aKA061) || aKA061 == null) {
			AKA061 = "无";
		} else {
			AKA061 = aKA061;
		}
	}

	public String getAKA062() {
		return AKA062;
	}

	public void setAKA062(String aKA062) {
		if ("".equals(aKA062) || aKA062 == null) {
			AKA062 = "无";
		} else {
			AKA062 = aKA062.trim();
		}
	}

	public String getAKA020() {
		return AKA020;
	}

	public void setAKA020(String aKA020) {
		if ("".equals(aKA020) || aKA020 == null) {
			AKA020 = "无";
		} else {
			AKA020 = aKA020;
		}
	}

	public String getBKA605() {
		return BKA605;
	}

	public void setBKA605(String bKA605) {
		if ("".equals(bKA605) || bKA605 == null) {
			BKA605 = "无";
		} else {
			BKA605 = bKA605;
		}
	}

	public String getAKA063() {
		return AKA063;
	}

	public void setAKA063(String aKA063) {
		if ("".equals(aKA063) || aKA063 == null) {
			AKA063 = "无";
		} else {
			AKA063 = aKA063;
		}
	}

	public String getAKA065() {
		return AKA065;
	}

	public void setAKA065(String aKA065) {
		if ("".equals(aKA065) || aKA065 == null) {
			AKA065 = "无";
		} else {
			AKA065 = aKA065;
		}
	}

	public String getAKA070() {
		return AKA070;
	}

	public void setAKA070(String aKA070) {
		if ("".equals(aKA070) || aKA070 == null) {
			AKA070 = "无";
		} else {
			AKA070 = aKA070;
		}
	}

	public String getAKA074() {
		return AKA074;
	}

	public void setAKA074(String aKA074) {
		if ("".equals(aKA074) || aKA074 == null) {
			AKA074 = "无";
		} else {
			AKA074 = aKA074;
		}
	}

	public String getBKA084() {
		return BKA084;
	}

	public void setBKA084(String bKA084) {
		if ("".equals(bKA084) || bKA084 == null) {
			BKA084 = "无";
		} else {
			BKA084 = bKA084;
		}
	}

	public String getAKB020() {
		return AKB020;
	}

	public void setAKB020(String aKB020) {
		if ("".equals(aKB020) || aKB020 == null) {
			AKB020 = "无";
		} else {
			AKB020 = aKB020;
		}
	}

	public String getBKA608() {
		return BKA608;
	}

	public void setBKA608(String bKA608) {
		if ("".equals(bKA608) || bKA608 == null) {
			BKA608 = "无";
		} else {
			BKA608 = bKA608;
		}
	}

	public String getAKA109() {
		return AKA109;
	}

	public void setAKA109(String aKA109) {
		if ("".equals(aKA109) || aKA109 == null) {
			AKA109 = "无";
		} else {
			AKA109 = aKA109;
		}
	}

	public String getBKA620() {
		return BKA620;
	}

	public void setBKA620(String bKA620) {
		if ("".equals(bKA620) || bKA620 == null) {
			BKA620 = "无";
		} else {
			BKA620 = bKA620;
		}
	}

	public String getBKA613() {
		return BKA613;
	}

	public void setBKA613(String bKA613) {
		if ("".equals(bKA613) || bKA613 == null) {
			BKA613 = "无";
		} else {
			BKA613 = bKA613;
		}
	}

	public String getBKC173() {
		return BKC173;
	}

	public void setBKC173(String bKC173) {
		if ("".equals(bKC173) || bKC173 == null) {
			BKC173 = "无";
		} else {
			BKC173 = bKC173;
		}
	}

	public String getALA011() {
		return ALA011;
	}

	public void setALA011(String aLA011) {
		if ("".equals(aLA011) || aLA011 == null) {
			ALA011 = "无";
		} else {
			ALA011 = aLA011;
		}
	}

	public String getAMA011() {
		return AMA011;
	}

	public void setAMA011(String aMA011) {
		if ("".equals(aMA011) || aMA011 == null) {
			AMA011 = "无";
		} else {
			AMA011 = aMA011;
		}
	}

	public String getAAE030() {
		return AAE030;
	}

	public void setAAE030(String aAE030) {
		if ("".equals(aAE030) || aAE030 == null) {
			AAE030 = "无";
		} else {
			AAE030 = aAE030;
		}
	}

	public String getAAE031() {
		return AAE031;
	}

	public void setAAE031(String aAE031) {
		AAE031 = aAE031;
	}

	public String getAAE100() {
		return AAE100;
	}

	public void setAAE100(String aAE100) {
		if ("".equals(aAE100) || aAE100 == null) {
			AAE100 = "无";
		} else {
			AAE100 = aAE100;
		}
	}

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

	public String getAAA027() {
		return AAA027;
	}

	public void setAAA027(String aAA027) {
		if ("".equals(aAA027) || aAA027 == null) {
			AAA027 = "无";
		} else {
			AAA027 = aAA027;
		}
	}

	public String getAAB034() {
		return AAB034;
	}

	public void setAAB034(String aAB034) {
		if ("".equals(aAB034) || aAB034 == null) {
			AAB034 = "无";
		} else {
			AAB034 = aAB034;
		}
	}

	public String getAAE011() {
		return AAE011;
	}

	public void setAAE011(String aAE011) {
		if ("".equals(aAE011) || aAE011 == null) {
			AAE011 = "无";
		} else {
			AAE011 = aAE011;
		}
	}

	public String getAAE036() {
		return AAE036;
	}

	public void setAAE036(String aAE036) {
		AAE036 = aAE036;
	}

	public String getBKA204() {
		return BKA204;
	}

	public void setBKA204(String bKA204) {
		if ("".equals(bKA204) || bKA204 == null) {
			BKA204 = "无";
		} else {
			BKA204 = bKA204;
		}
	}

	public String getBKA610() {
		return BKA610;
	}

	public void setBKA610(String bKA610) {
		if ("".equals(bKA610) || bKA610 == null) {
			BKA610 = "无";
		} else {
			BKA610 = bKA610;
		}
	}

	public String getBKA083() {
		return BKA083;
	}

	public void setBKA083(String bKA083) {
		if ("".equals(bKA083) || bKA083 == null) {
			BKA083 = "无";
		} else {
			BKA083 = bKA083;
		}
	}

	public String getBKA087() {
		return BKA087;
	}

	public void setBKA087(String bKA087) {
		if ("".equals(bKA087) || bKA087 == null) {
			BKA087 = "无";
		} else {
			BKA087 = bKA087;
		}
	}

	public String getAKA022() {
		return AKA022;
	}

	public void setAKA022(String aKA022) {
		if ("".equals(aKA022) || aKA022 == null) {
			AKA022 = "无";
		} else {
			AKA022 = aKA022;
		}
	}

	public String getBKA638() {
		return BKA638;
	}

	public void setBKA638(String bKA638) {
		if ("".equals(bKA638) || bKA638 == null) {
			BKA638 = "无";
		} else {
			BKA638 = bKA638;
		}
	}

	public String getBKA209() {
		return BKA209;
	}

	public void setBKA209(String bKA209) {
		if ("".equals(bKA209) || bKA209 == null) {
			BKA209 = "无";
		} else {
			BKA209 = bKA209;
		}
	}

	public String getBKA210() {
		return BKA210;
	}

	public void setBKA210(String bKA210) {
		if ("".equals(bKA210) || bKA210 == null) {
			BKA210 = "无";
		} else {
			BKA210 = bKA210;
		}
	}

	public String getBKA217() {
		return BKA217;
	}

	public void setBKA217(String bKA217) {
		if ("".equals(bKA217) || bKA217 == null) {
			BKA217 = "无";
		} else {
			BKA217 = bKA217;
		}
	}

	public String getBKA219() {
		return BKA219;
	}

	public void setBKA219(String bKA219) {
		if ("".equals(bKA219) || bKA219 == null) {
			BKA219 = "无";
		} else {
			BKA219 = bKA219;
		}
	}

	public String getBKA221() {
		return BKA221;
	}

	public void setBKA221(String bKA221) {
		if ("".equals(bKA221) || bKA221 == null) {
			BKA221 = "无";
		} else {
			BKA221 = bKA221;
		}
	}

	public String getBKA222() {
		return BKA222;
	}

	public void setBKA222(String bKA222) {
		if ("".equals(bKA222) || bKA222 == null) {
			BKA222 = "无";
		} else {
			BKA222 = bKA222;
		}
	}

	public String getBKA225() {
		return BKA225;
	}

	public void setBKA225(String bKA225) {
		if ("".equals(bKA225) || bKA225 == null) {
			BKA225 = "无";
		} else {
			BKA225 = bKA225;
		}
	}

	public String getBKA226() {
		return BKA226;
	}

	public void setBKA226(String bKA226) {
		if ("".equals(bKA226) || bKA226 == null) {
			BKA226 = "无";
		} else {
			BKA226 = bKA226;
		}
	}

	public String getBKA228() {
		return BKA228;
	}

	public void setBKA228(String bKA228) {
		if ("".equals(bKA228) || bKA228 == null) {
			BKA228 = "无";
		} else {
			BKA228 = bKA228;
		}
	}

	public String getBKA231() {
		return BKA231;
	}

	public void setBKA231(String bKA231) {
		if ("".equals(bKA231) || bKA231 == null) {
			BKA231 = "无";
		} else {
			BKA231 = bKA231;
		}
	}

	public String getBKA232() {
		return BKA232;
	}

	public void setBKA232(String bKA232) {
		if ("".equals(bKA232) || bKA232 == null) {
			BKA232 = "无";
		} else {
			BKA232 = bKA232;
		}
	}

	public String getBKA233() {
		return BKA233;
	}

	public void setBKA233(String bKA233) {
		if ("".equals(bKA233) || bKA233 == null) {
			BKA233 = "无";
		} else {
			BKA233 = bKA233;
		}
	}

	public String getBKA234() {
		return BKA234;
	}

	public void setBKA234(String bKA234) {
		if ("".equals(bKA234) || bKA234 == null) {
			BKA234 = "无";
		} else {
			BKA234 = bKA234;
		}
	}

	public String getBKA235() {
		return BKA235;
	}

	public void setBKA235(String bKA235) {
		if ("".equals(bKA235) || bKA235 == null) {
			BKA235 = "无";
		} else {
			BKA235 = bKA235;
		}
	}

	public String getBKA236() {
		return BKA236;
	}

	public void setBKA236(String bKA236) {
		if ("".equals(bKA236) || bKA236 == null) {
			BKA236 = "无";
		} else {
			BKA236 = bKA236;
		}
	}

	public String getBKA237() {
		return BKA237;
	}

	public void setBKA237(String bKA237) {
		if ("".equals(bKA237) || bKA237 == null) {
			BKA237 = "无";
		} else {
			BKA237 = bKA237;
		}
	}

	public String getBKA240() {
		return BKA240;
	}

	public void setBKA240(String bKA240) {
		if ("".equals(bKA240) || bKA240 == null) {
			BKA240 = "无";
		} else {
			BKA240 = bKA240;
		}
	}

	public String getBKA246() {
		return BKA246;
	}

	public void setBKA246(String bKA246) {
		if ("".equals(bKA246) || bKA246 == null) {
			BKA246 = "无";
		} else {
			BKA246 = bKA246;
		}
	}

	public String getBKA247() {
		return BKA247;
	}

	public void setBKA247(String bKA247) {
		if ("".equals(bKA247) || bKA247 == null) {
			BKA247 = "无";
		} else {
			BKA247 = bKA247;
		}
	}

	public String getBKA248() {
		return BKA248;
	}

	public void setBKA248(String bKA248) {
		if ("".equals(bKA248) || bKA248 == null) {
			BKA248 = "无";
		} else {
			BKA248 = bKA248;
		}
	}

	public String getBKA249() {
		return BKA249;
	}

	public void setBKA249(String bKA249) {
		if ("".equals(bKA249) || bKA249 == null) {
			BKA249 = "无";
		} else {
			BKA249 = bKA249;
		}
	}

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

}
