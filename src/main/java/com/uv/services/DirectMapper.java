package com.uv.services;

import java.util.LinkedHashMap;
import java.util.List;

public interface DirectMapper {
    List<LinkedHashMap<String, Object>> select(String sql);
    int insert(String sql);
    int update(String sql);
    int delete(String sql);
}
