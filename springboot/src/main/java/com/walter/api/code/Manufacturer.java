package com.walter.api.code;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

@Getter
public enum Manufacturer {
	SONY("소니 인터랙티브 엔터테인먼트", "미국 캘리포니아주 산 마테오 브릿지포인트 파크웨이 2207"),
	SEGA("주식회사 세가", "일본 도쿄도 시나가와구 니시시나가와 1쵸메 1-11 스미토모부동산 오자키 가든타워"),
	NINTENDO("닌텐도 주식회사", "일본 교토부 교토시 미나미구 카미토바 호코타테초 11-1"),
	MICROSOFT("마이크로소프트", "미국 워싱턴주 레드먼드 300 데슈테츠 웨이 사우스웨스트 208 MC-CSC1"),
	NEC("일본전기 주식회사", "일본 도쿄도 미나토구 시바 5-7-1."),
	NOTHING(StringUtils.EMPTY, StringUtils.EMPTY);

	private String company;
	private String address;

	Manufacturer(String company, String address) {
		this.company = company;
		this.address = address;
	}

	public static Manufacturer findByCode(String code) {
		return Arrays.stream(Manufacturer.values()).filter(manufacturer -> manufacturer.name().equals(code))
												   .findFirst()
												   .orElse(NOTHING);
	}
}
