package com.lty.designs.Menu;


import com.lty.designs.ceiling.LevelOneCeiling;
import com.lty.designs.ceiling.LevelTwoCeiling;
import com.lty.designs.coat.DuluxCoat;
import com.lty.designs.coat.LiBangCoat;
import com.lty.designs.floor.ShengXiangFloor;
import com.lty.designs.tile.DongPengTile;
import com.lty.designs.tile.MarcoPoloTile;

public class Builder {

    public Menu levelOne(Double area) {
        return new MenuImpl(area, "豪华欧式")
                .addCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .addCoat(new DuluxCoat())             // 涂料，多乐士
                .addFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public Menu levelTwo(Double area){
        return new MenuImpl(area, "轻奢田园")
                .addCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .addCoat(new LiBangCoat())           // 涂料，立邦
                .addTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public Menu levelThree(Double area){
        return new MenuImpl(area, "现代简约")
                .addCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .addCoat(new LiBangCoat())           // 涂料，立邦
                .addTile(new DongPengTile());        // 地砖，东鹏
    }

}
