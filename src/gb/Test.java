package gb;

import java.util.ArrayList;
import java.util.Date;

import gb.model.beans.GuestbookEntry;
import gb.model.db.DatabaseException;
import gb.model.db.Guestbook;

public class Test {
	
	public static boolean compare(GuestbookEntry a, GuestbookEntry b)
	{
		if(a.getAuthor().equals(b.getAuthor()))
		{
			if(a.getDate().getYear()==b.getDate().getYear())
			{
				if(a.getDate().getSeconds()==b.getDate().getSeconds())
				{
					if(a.getEmail().equals(b.getEmail()))
					{
						if(a.getText().equals(b.getText()))
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		GuestbookEntry entry0 = new GuestbookEntry();
		entry0.setAuthor("mixi");
		entry0.setDate(new Date());
		entry0.setEmail("any@body.net");
		entry0.setText("my guestbook entry");
		
		GuestbookEntry entry1 = new GuestbookEntry();
		entry1.setAuthor("m!xi");
		entry1.setDate(new Date());
		entry1.setEmail("some@one.net");
		entry1.setText("another entry");
		
		GuestbookEntry entry2 = new GuestbookEntry();
		entry2.setAuthor("mix!");
		entry2.setDate(new Date());
		entry2.setEmail("angy@man.net");
		entry2.setText("flaming entry");
		
		Guestbook gb = Guestbook.getInstance();
		gb.init(".");
		try {
			gb.addEntry(entry0);			
			gb.addEntry(entry1);			
			gb.addEntry(entry2);			
			
			ArrayList<GuestbookEntry> entries = gb.getAllEntries();
			
			if(compare(entry0, entries.get(0)))
			{
				if(compare(entry1, entries.get(1)))
				{
					if(compare(entry2, entries.get(2)))
					{
						System.out.println("ALL MATCH!");
						return;
					}
				}
			}
			System.out.println("#fail");
		} catch (DatabaseException e) {
			e.printStackTrace();
		}
	}
}
