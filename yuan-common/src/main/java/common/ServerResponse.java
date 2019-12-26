package common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private int status;
    private String msg;
    private T data;

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status, String msg){
        this.status = status;
        this.msg =msg;
    }
    private ServerResponse(int status, T data){
        this.status = status;
        this.data = data;
    }
    private ServerResponse(int status, String msg, T data ){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    @JsonIgnore
    public boolean isSuccess(){
       return  this.status == ResultStatusEnum.SUCCESS.getCode();
    }

    public static<T> ServerResponse<T> createSuccess(){
        return  new ServerResponse<T>(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getProductDescription());
    }
    public static<T> ServerResponse<T> createSuccess(String msg){
        return  new ServerResponse<T>(ResultStatusEnum.SUCCESS.getCode(), msg);
    }
    public static<T> ServerResponse<T> createSuccess(T data ){
        return  new ServerResponse<T>(ResultStatusEnum.SUCCESS.getCode(), ResultStatusEnum.SUCCESS.getProductDescription(), data);
    }
    public static<T> ServerResponse<T> createSuccess(String msg, T data){
        return  new ServerResponse<T>(ResultStatusEnum.SUCCESS.getCode(), msg, data);
    }
    public static<T> ServerResponse<T> createSuccess(int code,String msg, T data){
        return  new ServerResponse<T>(code, msg, data);
    }


    public static<T> ServerResponse<T> createError(){
        return  new ServerResponse<T>(ResultStatusEnum.ERROR.getCode(), ResultStatusEnum.ERROR.getProductDescription());
    }
    public static<T> ServerResponse<T> createError(String msg){
        return  new ServerResponse<T>(ResultStatusEnum.ERROR.getCode(), msg);
    }
    public static<T> ServerResponse<T> createError(String msg, T data){
        return  new ServerResponse<T>(ResultStatusEnum.ERROR.getCode(), msg,data);
    }
    public static<T> ServerResponse<T> createError(int status,String msg){
        return  new ServerResponse<T>(status, msg);
    }
    public static<T> ServerResponse<T> createError(int status,String msg, T data){
        return  new ServerResponse<T>(status, msg,data);
    }

    /**
     * 将json结果集转化为ServerResponse对象
     *
     * @param jsonData json数据
     * @param clazz ServerResponse中的object类型
     * @return
     */
    public static ServerResponse formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ServerResponse.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return new ServerResponse(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static ServerResponse format(String json) {
        try {
            return MAPPER.readValue(json, ServerResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static ServerResponse formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return new ServerResponse(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }


}
