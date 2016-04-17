package openTapsGroups;
import org.testng.annotations.Test;
public class EditContact extends OpenTapsWrapper{

	@Test(groups="sanity",dependsOnGroups="smoke")
	public void editcontact()
	{
		System.out.println("Contact Edited");
	}
}
