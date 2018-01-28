package myblog.dao.entity.dict;

public enum ResourceType
{
	A_XTGL("系统管理", "xtgl.png","fa fa-cog") {},
	B_SAMPLE("示例", "xlgl.png","fa fa-align-left") {},
	C_CONFIG("配置", "xlgl.png","fa fa-cogs") {},
	D_CONFIG("配置", "xlgl.png","icon24_nav03") {},
	E_XMGL("配置", "xlgl.png","icon24_nav03") {},
	;

	private final String value;
	private final String logoPic;
	private final String logoClass;

	private ResourceType(String value, String logoPic, String logoClass)
	{
		this.value = value;
		this.logoPic = logoPic;
		this.logoClass = logoClass;
	}

	public String getLogoClass()
	{
		return logoClass;
	}

	public String getValue()
	{
		return value;
	}

	public String getLogoPic()
	{
		return logoPic;
	}
}