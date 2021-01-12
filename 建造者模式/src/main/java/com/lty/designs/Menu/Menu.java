package com.lty.designs.Menu;

import com.lty.designs.Matter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2020/11/13 10:31
 */
public interface Menu {
    Menu addCeiling(Matter matter);
    Menu addCoat(Matter matter);
    Menu addFloor(Matter matter);
    Menu addTile(Matter matter);
    String getDetail();


}
