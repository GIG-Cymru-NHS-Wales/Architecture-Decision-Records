# Git Alias Commands

!!! info

    **Status**: WIP RFC
    
    **Updated**: 2025-03-28

## Summary

We're having pain points adopting git because of typical reasons, such as the
git command line having a high learning curve. This is especially painful for
longer git practices, such as when a developer wants to create a topic branch.
We want to simplify this by using git alias commands, such as "git lg" meaning
"git log --graph" and "git topic-start" meaing create a new topic branch based
on the main branch.

## Drivers

### Context

In our development environment, frequent interactions with Git are essential. Standard Git commands can be verbose and repetitive, leading to inefficiencies. To streamline workflows and reduce cognitive load, we seek a solution that provides:

* Shortened commands for common Git operations.

* Enhanced readability and consistency across teams.

* Easy customization to fit team-specific workflows.

### Timing

* Now: We're aiming to upskill 30+ testers starting within 30 days, and we want thme all to learn git, including the git command line interface, so they can participate in our testing repos.

* Soon: We are hiring more developers and testers, and we want to have something ready for them to use that aligns with the rest of the teams.

* Skills: Our teams have a wide range of git skills. Some teammates know it well and can lead teaching it. Some teammates are new to it. 

### Experience

Joel has taught git to many tech teams, and it tends to go better when the team learns git alias commands:

* Makes typiing faster e.g. "git s" means "git status".

* Explains comcepts e.g. "git list-branches" is easy to understand.

* Helps maintain repos e.g. "git hew" deletes merged branches

* Most important, topic branch aliases keep the core workflows on track, and can
  also be customized per team.

## Options

## Alternatives Considered

* **GitAlias.com**: A collection of many git alias commands that Joel maintains and teachers.
  
* **Manual Alias Configuration**: Individually setting up aliases in each developer's `.gitconfig` file.

* **Custom Scripts**: Creating shell scripts to wrap Git commands.

## Analyses

### GitAlias.com*

**GitAlias.com**: A collection of many git alias commands that Joel maintains and teachers.

* *Pros*: Proven succcess with teams of teams in many companies of many sizes.

* *Cons*: A developer must download the file and save it locally.
  
### Manual Alias Configuration

**Manual Alias Configuration**: Individually setting up aliases in each developer's `.gitconfig` file.

* *Pros*: Full control over alias definitions.

* *Cons*: Time-consuming and prone to inconsistencies.

### Custom Scripts

**Custom Scripts**: Creating shell scripts to wrap Git commands.

* *Pros*: Flexibility in command execution.

* *Cons*: Requires additional maintenance and may not integrate seamlessly with Git.


## Recommendation

1. **Adopt GitAlias**: Integrate the GitAlias configuration into the team's Git setup.

2. **Customize as Needed**: Modify aliases to align with specific team workflows.

3. **Documentation**: Update internal documentation to reflect the new aliases and their usage.

4. **Training**: Conduct a session to familiarize the team with the new aliases.([GitHub][2])

### Consequences

Pros:

* **Increased Efficiency**: Shortened commands reduce typing time and potential errors.

* **Consistency**: Standardized aliases across the team enhance collaboration and understanding.

* **Customization**: The ability to modify aliases allows adaptation to specific workflow needs.

Cons:

* **Learning Curve**: Team members need to familiarize themselves with the new aliases.

* **Potential Conflicts**: Custom aliases might conflict with existing ones or third-party tools.

### Confirmation

{This section is **optional**.}

{Outline how the implementation of this decision will be verified and how
ongoing compliance will be ensured. This helps demonstrate that the decision
isn't just theoretical but will be actively put into practice and monitored.

How will you check that the decision has been correctly implemented?
(e.g., code reviews, specific tests, demonstrations, peer review).

How will adherence to this decision be maintained over time? (e.g., automated
checks, periodic audits, updates to team guidelines, training).

Are there specific metrics or indicators that will show the decision is
achieving its intended positive outcomes? (e.g., performance benchmarks,
adoption rates, reduction in specific errors, user feedback scores).

Who is responsible for overseeing this, and what happens if the decision is
not followed?}

## More Information

{This section is **optional**.}

{Use this section to provide any supplementary information that supports the
decision, adds context, or guides future actions. Links to other decisions
and resources might appear here as well.

You could briefly note who was involved in the decision-making process and
if/how consensus was reached. You may also want to suggest a timeframe or
specific events that might prompt a re-evaluation of this decision in the
future.}
