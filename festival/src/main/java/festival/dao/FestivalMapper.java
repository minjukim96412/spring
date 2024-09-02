package festival.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import festival.domain.Festival;
import java.util.List;

public interface FestivalMapper {

    @Insert({
        "<script>",
        "INSERT ALL",
        "<foreach collection='list' item='item' separator=' '>",
        "INTO festival (contentid, contenttypeid, areacode, title, addr1, addr2, mapx, mapy, firstimage, firstimage2, eventstartdate, eventenddate, tel)",
        "VALUES (#{item.contentid}, #{item.contenttypeid}, #{item.areacode}, #{item.title}, #{item.addr1}, #{item.addr2}, #{item.mapx}, #{item.mapy},",
        "#{item.firstimage}, #{item.firstimage2}, #{item.eventstartdate}, #{item.eventenddate}, #{item.tel})",
        "</foreach>",
        "SELECT 1 FROM dual",
        "</script>"
    })
    void saveFestival(@Param("list") List<Festival> festivalList);
    
    @Select("SELECT * FROM festival")
    List<Festival> getAllFestivals();

    @Select("SELECT * FROM festival WHERE overviewYN IS NULL")
    List<Festival> getFestivalsWithNullOverviewYN();

    @Select("SELECT * FROM festival WHERE playtime IS NULL AND usetimefestival IS NULL")
    List<Festival> getFestivalsWithNullAdditionalDetails();

    @Update({
        "<script>",
        "UPDATE festival",
        "<set>",
        "<if test='overviewYN != null'>overviewYN = #{overviewYN},</if>",
        "</set>",
        "WHERE contentid = #{contentid}",
        "</script>"
    })
    void updateFestivalOverviewYN(Festival festival);

    @Update({
        "<script>",
        "UPDATE festival",
        "<set>",
        "<if test='playtime != null'>playtime = #{playtime},</if>",
        "<if test='usetimefestival != null'>usetimefestival = #{usetimefestival},</if>",
        "</set>",
        "WHERE contentid = #{contentid}",
        "</script>"
    })
    void updateFestivalAdditionalDetails(Festival festival);
}
