Feature: print line

As a computer user I
want to print a message
So I can see that the print option is working

Scenario Outline: print line

Given I type a "<message_input>"
Then The "<message_output>" should show on the screen

Examples:
| message_input | message_output |
|  hallo        | hallo			 |
|  world        | world          |