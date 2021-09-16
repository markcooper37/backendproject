package com.example.demo.ward;

import java.util.List;

public interface WardDAO {
    List<Ward> selectAllWards();
    int insertWard(Ward ward);
    int deleteWard(Ward ward);
}
