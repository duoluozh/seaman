package com.lhh.seamanrecruit.utils;

import com.lhh.seamanrecruit.dto.resume.ResumeAddDto;
import com.lhh.seamanrecruit.entity.Resume;
import com.lhh.seamanrecruit.entity.ResumeDetails;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhh
 * @date 2022/4/15 20:34
 * @description
 */
public class CopyUtils {
    /**
     * 单体复制
     */
    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        T obj = null;
        try {
            obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }

    /**
     * 列表复制
     */
    public static <T> List<T> copyList(List source, Class<T> clazz) {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)){
            for (Object c: source) {
                T obj = copy(c, clazz);
                target.add(obj);
            }
        }
        return target;
    }

    public static void main(String[] args) {
        ResumeAddDto resumeAddDto = new ResumeAddDto();
        resumeAddDto.setId(1L);
        resumeAddDto.setAge(30);
        System.out.println(resumeAddDto);
        Resume resume = CopyUtils.copy(resumeAddDto, Resume.class);
        System.out.println(resume);
        ResumeDetails details = CopyUtils.copy(resumeAddDto, ResumeDetails.class);
        System.out.println(details);
    }
}
