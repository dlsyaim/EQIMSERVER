package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TunnelCondition;

//隧道构造sql类
public class TunnelProvider {
    //查询总记录数
    public String getTunnelCount(TunnelCondition tunnelCondition){
        StringBuilder builder =new StringBuilder("select count(1) count from TUNNEL t where 1=1");
        if(tunnelCondition.getTunnelName()!=null&&!"".equals(tunnelCondition.getTunnelName())){
            builder.append(" and t.name like concat(concat('%',#{tunnelName}),'%')");
        }
        if(tunnelCondition.getTunnelClass()!=null&&!"".equals(tunnelCondition.getTunnelClass())){
            builder.append(" and t.class like concat(concat('%',#{tunnelClass}),'%')");
        }
        if(tunnelCondition.getTunnelGrade()!=null&&!"".equals(tunnelCondition.getTunnelGrade())){
            builder.append(" and t.grade like concat(concat('%',#{tunnelGrade}),'%')");
        }
        if(tunnelCondition.getTunnelIntensity()!=null&&!"".equals(tunnelCondition.getTunnelIntensity())){
            builder.append(" and t.intensity like concat(concat('%',#{tunnelIntensity}),'%')");
        }

        return builder.toString();
    }

    //查询数据列表
    public String getTunnelList(TunnelCondition tunnelCondition){
        StringBuilder builder =new StringBuilder("select * from(select t.*,rownum rn from (select " +
                "t.objectid,t.name as tunnelName,t.class as tunnelClass," +
                "t.location,t.grade as tunnelGrade,t.length as tunnelLength," +
                "t.width as tunnelWidth,t.height as tunnelHeight,t.number_line,t.intensity," +
                "t.built_era,t.note_  as tunnelNote from TUNNEL t where 1=1 ");
        if(tunnelCondition.getTunnelName()!=null&&!"".equals(tunnelCondition.getTunnelName())){
            builder.append(" and t.name like concat(concat('%',#{tunnelName}),'%')");
        }
        if(tunnelCondition.getTunnelClass()!=null&&!"".equals(tunnelCondition.getTunnelClass())){
            builder.append(" and t.class like concat(concat('%',#{tunnelClass}),'%')");
        }
        if(tunnelCondition.getTunnelGrade()!=null&&!"".equals(tunnelCondition.getTunnelGrade())){
            builder.append(" and t.grade like concat(concat('%',#{tunnelGrade}),'%')");
        }
        if(tunnelCondition.getTunnelIntensity()!=null&&!"".equals(tunnelCondition.getTunnelIntensity())){
            builder.append(" and t.intensity like concat(concat('%',#{tunnelIntensity}),'%')");
        }

        builder.append(" and rownum<=#{top})t) t where t.rn >#{bottom}");

        return builder.toString();
    }

    //获取类别下拉列表
    public String getTunnelClassList(){
        StringBuilder builder =new StringBuilder("select distinct t.class as tunnel_class from TUNNEL t where t.class is not null");
        return builder.toString();
    }

    //获取桥梁等级下拉列表
    public String getTunnelGradeList(){
        StringBuilder builder =new StringBuilder("select distinct t.grade as tunnel_grade from TUNNEL t where t.grade is not null");
        return builder.toString();
    }
}
