package openTapsGroups;
import org.testng.annotations.Test;
public class DeleteLead extends OpenTapsWrapper{

	@Test(groups="sanity",dependsOnGroups="smoke")
	public void deletelead()
	{
		System.out.println("Lead Deleted");
	}
}
