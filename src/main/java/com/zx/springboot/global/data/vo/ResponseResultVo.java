package com.zx.springboot.global.data.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zx.springboot.global.enums.IMsgEnumType;
import com.zx.springboot.utils.util.constants.ApiDesc;
import org.apache.commons.lang3.ClassUtils;

public class ResponseResultVo {


    @ApiDesc(value= "返回结果 -- 状态码: 成功为0; 其它为错误类型")
	private int code = 0;     //状态码
    @ApiDesc(value= "返回结果 -- 状态对应描述: 成功为空")
	private String msg = "";     //状态描述
    @ApiDesc(value= "返回结果 -- 服务时间,格式为时间截,单位为毫秒")
	private long times = System.currentTimeMillis();        //时间戳 13位
    @ApiDesc(value= "返回结果 -- 结果数据对象")
	private Object data = new JSONObject();    //Json 内容

	public ResponseResultVo(){

	}

	public static ResponseResultVo build(){
		return new ResponseResultVo();
	}

    public static ResponseResultVo error(IMsgEnumType enumType){
        return  build().setCodeMsg(enumType.getCode(),enumType.getMsg());
    }

	public ResponseResultVo setCodeMsg(int code, String msg){
		return this.setCode(code).setMsg(msg);
	}

	public int getCode() {
		return code;
	}

	public ResponseResultVo setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResponseResultVo setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

    public ResponseResultVo setData(Object data) {
        if(!ClassUtils.isPrimitiveOrWrapper(data.getClass())){
            this.data = data;
            return this;
        }
        if(data instanceof  Boolean){
            int value = (Boolean)data ? 1 : 0;
            return setData("result", value);
        }
        setData("id",data);
        return this;
    }

	public ResponseResultVo setData(String result, Object value){
		JSONObject object = new JSONObject();
		object.put(result,value);
		data = object;
        return this;
	}

    public long getTimes() {
        return times;
    }

    public String toString(){
		return JSON.toJSONString(this);
	}
}
