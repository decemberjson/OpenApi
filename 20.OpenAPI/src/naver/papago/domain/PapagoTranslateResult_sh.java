package naver.papago.domain;

public class PapagoTranslateResult_sh {

	private String translatedText;
	private String srcLangType;
	
	// Google Vision 에서 경복궁에 대한 
	// English Value 도메인에 바인딩했다는 가정하에...
	public String translateSource = "Gyeongbokgung Palace";
	
	
	public PapagoTranslateResult_sh() {
	}


	public String getTranslatedText() {
		return translatedText;
	}

	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
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
		return "PapagoTranslateResult_sh [translatedText=" + translatedText + ", srcLangType=" + srcLangType
				+ ", translateSource=" + translateSource + "]";
	}

	
	
}
