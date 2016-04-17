package openTapsGroups;
import org.testng.annotations.Test;
public class DeleteContact extends OpenTapsWrapper{

	@Test(groups="sanity",dependsOnGroups="smoke")
	public void deletecontact()
	{
		System.out.println("Contact Deleted");
	}
}
