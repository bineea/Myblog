package myblog.common.entity;

import com.fasterxml.jackson.annotation.JsonFilter;

import myblog.common.tools.JsonTools;

@JsonFilter(value = JsonTools.FILTER_NAME)
public abstract class BaseEntity {

}
