import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class getTaskManageInfo
{
    public List Tasklist()
    {
        List list=new ArrayList();
        try
        {
            Process process = Runtime.getRuntime().exec("tasklist");
            Scanner in=new Scanner(process.getInputStream());
            while(in.hasNextLine()){
                String p=in.nextLine();
                list.add(p);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return list;
    }
    public List rtTasklist(List list)
    {
        List array=new ArrayList();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).toString().indexOf(".EXE")!=-1)
            {
                array.add(list.get(i).toString().substring(0,list.get(i).toString().indexOf(".EXE")));
            }
            else if(list.get(i).toString().indexOf(".exe")!=-1)
            {
                array.add(list.get(i).toString().substring(0,list.get(i).toString().indexOf(".exe")));
            }
        }
        return array;
    }
    public static void main(String[] args) {
        getTaskManageInfo test=new getTaskManageInfo();
        List array=test.Tasklist();
        List list=test.rtTasklist(array);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
        //System.out.println(list.size());
    }
}
