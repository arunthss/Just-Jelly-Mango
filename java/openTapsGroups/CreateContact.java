package openTapsGroups;

import org.testng.annotations.Test;
public class CreateContact extends OpenTapsWrapper
{
	@Test(groups="smoke")
	public void createcontact()
	{
		System.out.println("Contact Created");
	}
}
