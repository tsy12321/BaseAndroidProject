package com.tsy.baseandroidproject.SampleModeule.data;

import java.io.Serializable;

/**
 * Created by tsy on 16/7/26.
 */
public class SampleInfo implements Serializable {

    private static final long serialVersionUID = 1L; // 定义序列化ID

    public int sample_id;   //sample_id
    public String sample_name;  //sample_name
    public String create_time;  //create_time
    public String end_time;  //end_time
    public String avatar;       //avatar
}
