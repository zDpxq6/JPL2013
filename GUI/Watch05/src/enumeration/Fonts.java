package enumeration;

import constant.EnumInterfaceforClient;


public enum Fonts implements EnumInterfaceforClient<String>{
	DIALOG,

	DIALOG_INPUT,

	MONOSPACED,

	SANS_SERIF,

	SERIF,;

	@Override
	public String getValue() {
		return this.toString();
	}
}
