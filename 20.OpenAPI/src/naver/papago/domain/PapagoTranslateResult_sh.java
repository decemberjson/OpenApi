package naver.papago.domain;

public class PapagoTranslateResult_sh {

	private String translatedText;
	private String tarLangType;
	private String srcLangType;
	
	// Google Vision 에서 경복궁에 대한 
	// English Value 도메인에 바인딩했다는 가정하에...
	// 하나씩 주석처리해서 확인해 볼것 (SMT / NMT) - 둘다 값 다르게 나옴
	public String translateSource = "Gyeongbokgung Palace";
//	public String translateSource = "Gyeongbok Palace";
	
	
	public PapagoTranslateResult_sh() {
	}
	

	public String getTranslatedText() {
		return translatedText;
	}

	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

	public String getTarLangType() {
		return tarLangType;
	}
	public void setTarLangType(String tarLangType) {
		this.tarLangType = tarLangType;
	}

	public String getSrcLangType() {
		return srcLangType;
	}

	public void setSrcLangType(String srcLangType) {
		this.srcLangType = srcLangType;
	}

	public String getTranslateSource() {
		return translateSource;
	}

	public void setTranslateSource(String translateSource) {
		this.translateSource = translateSource;
	}


	@Override
	public String toString() {
		return "PapagoTranslateResult_sh [translatedText=" + translatedText + ", tarLangType=" + tarLangType
				+ ", srcLangType=" + srcLangType + ", translateSource=" + translateSource + "]";
	}

	
	

	
	
}
