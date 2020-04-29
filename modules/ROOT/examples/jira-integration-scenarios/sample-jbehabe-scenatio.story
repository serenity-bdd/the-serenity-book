Frequent Flyer status is calculated based on points

Meta:
@issue #FH-17

Scenario: New members should start out as Bronze members
Given Jill Smith is not a Frequent Flyer member
When she registers on the Frequent Flyer program
Then she should have a status of Bronze

Scenario: Members should get status updates based on status points earned
Given a member has a status of <initialStatus>
And he has <initialStatusPoints> status points
When he earns <extraPoints> extra status points
Then he should have a status of <finalStatus>
Examples:
| initialStatus | initialStatusPoints | extraPoints | finalStatus | notes                    |
| Bronze        | 0                   | 300         | Silver      | 300 points for Silver    |
| Silver        | 0                   | 700         | Gold        | 700 points for Gold      |
| Gold          | 0                   | 1500        | Platinum    | 1500 points for Platinum |