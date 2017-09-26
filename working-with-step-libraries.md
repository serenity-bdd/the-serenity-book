One of the keys to writing good tests is getting the layers right. Test suites are more maintainable when they are organised in clear, well defined layers. This helps our brain concentrate on one thing at a time. 

## Basic Step Libraries

In Serenity, we use step libraries to better organise our test logic into reusable components.

Step libraries are often used to represent actors or persona who interact with the application. For example, we might have an `AccountHolder` step library that represents how a client interacts with a banking application to open and manage her account.

`public static class AccountHolder {`



`	private long newBankAccountNumber = 0;`



`	/**`

`	 * A client opens a new bank account via the client website.`

`	 * We record the bank account number for future use`

`	 */`

`	@Step`

`	public void opensABankAccount() {...}`



`	/**`

`	 * Does this client have an open account?`

`	 */`

`	public boolean hasAnOpenAccount() { ... }`



`	/**`

`	 * What is the new bank account number for this customer?`

`	 */`

`	public long newBankAccountNumber() {`

`		return newBankAccountNumber;`

`	}`

`}`







