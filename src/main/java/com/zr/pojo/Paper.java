package com.zr.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.zr.utils.DateJsonSerialize;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 * @author zr
 * 
 * @date 2018-09-10
 */
public class Paper{
    private Integer paId;

    private String path;

    private String papername;

    @JsonSerialize(using = DateJsonSerialize.class)
    private Date createtime;

    private String paperdesc;

    public Integer getPaId() {
        return paId;
    }

    public void setPaId(Integer paId) {
        this.paId = paId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPapername() {
        return papername;
    }

    public void setPapername(String papername) {
        this.papername = papername == null ? null : papername.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }


    public String getPaperdesc() {
        return paperdesc;
    }

    public void setPaperdesc(String paperdesc) {
        this.paperdesc = paperdesc == null ? null : paperdesc.trim();
    }


}