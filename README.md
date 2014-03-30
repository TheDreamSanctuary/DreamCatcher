DreamCatcher
============

Vote Ban/Kick system 

Specs
===
Dreamcatcher Ban tool Specifications
----------------

The tool will require a config of some sort, i recommend the following at bare minimum
below is a listed requirement for the config.

[Anything in Square brackets are our suggestions for our server]

file location for logs
C:/__________

VTKick <Playername> Reason
- Total Time (S/M/H) [30min]
-Required votes above No votes: [3]
-Rank Required to use: [Apprentice]
-Players who can vote: [Apprentice]
-Vote timer: (S/M/H) [30sec]
	-Default reason: temp kicked for <Time> Minutes.

VTBan <Playername> Reason
- Total Time (Minutes) [2880 (48h)]
-Required votes above No votes: [3]
-Rank Required to use: [Journeyman]
-Vote timer: (S/M/H) [30sec]
	-Default reason: temp banned for <Time> <Seconds/Minutes/Hours>.

TKick <Playername> Reason
- Total Time (Minutes) [30min]
-Rank Required to use: [Journeyman]
	-Default reason: temp kicked for <Time> Minutes.

TBan <Playername> Reason
- Total Time (Minutes) [720 (12h)]
-Rank Required to use: [Journeyman]
-Default reason: temp banned for <Time> <Seconds/Minutes/Hours>.








DTKick <Playername> <Time> Reason
-Rank Required to use: [Artisan]
	-Default reason: temp kicked for <Time> Minutes.

DTBan <Playername> <Time> Reason
-Rank Required to use: [Artisan]
-Default reason: temp banned for <Time> <Seconds/Minutes/Hours>.

DBan <Playername> Reason
-Rank Required to use: [Artisan]
-Default reason: temp banned for Perminantly

/DC Cancel <Playername>
	cancels voting.
	updates entry to say “canceled”
/DC list
(Lists all open tickets) 

/DC list all <i> 
(lists all tickets in logs)


/DC read <ban name>

an example of this would be /DC read Starjik_7

- the number would be generated because the player has already had a temp ban and auto numbered to have the next numeric.

/DC Close <ban name>

unbans said player, changes entry for said banned to included

Closed by: <player>

/DC Commit <ban name>

bans player permanently, changes entry for said ban to include

Committed by: <player>










Back end stuff:

when a ban is initiated it would create an entry for the player being potentially temp banned.  the entry would be <Name>_[Autonumber]

the number would be in accordance with how many temp bans they have had.

when the kick/ban is initiated, creates the entry to say:

<Playername>_[Autonumber] 
Ban Type - Time banned for:
Reason for ban

Time of temp ban resolution:
Player who used command:  
Players who voted yes:
Players who voted no:
Closed by/Commited by: <Player>/Open/Canceled vote

Example: doesnt have to be in this format ofc.

Starjik_5
Temporary - 48h
“He was being a cunt”
Initiator: Jmck
Yays: 
Wingman
SekerAsar
Thimbletack
Butters
Nays:
Dumples




it would output the data into two places: a log, 

said log would be named DC_<Playername>

the other is some kind of system storage - maybe a miniature database/library of some kind.



Master log:

this would be for all initators of the bans/kicks - it only adds the entries in the sense of...

[Date/Time(GMT)] - <Player initator>: <player> <reason>
