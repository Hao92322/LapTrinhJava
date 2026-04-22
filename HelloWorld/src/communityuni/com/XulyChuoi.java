package communityuni.com;
import java.util.regex.*;
public class XulyChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String path = "D:/music/bolero/longme.mp3";
			String[] director = path.split("/");
			String musicfile = director[director.length-1];
			String[] musicfileNotmp3 = musicfile.split("\\.");//ky tu . la ky tu dat biet phai dung\\.
			System.out.println(musicfile);
			System.out.println(musicfileNotmp3[0]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}
