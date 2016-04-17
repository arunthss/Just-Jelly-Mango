package openTapsGroups;
import org.testng.annotations.Test;
public class MergeContact extends OpenTapsWrapper{

	@Test(groups="sanity",dependsOnGroups="smoke")
	public void mergecontact()
	{
		System.out.println("Contact merged");
	}
}
