# Where are you?
## Real time location tracker

Fronted contains an Android app which will installed in User's phone.<br />
Backend can be hosted anywhere, a single page JS provide you a Mapbox interface which tracks and locate that user in realtime. 

### Why I made this?

``` {
	"MOM to ME": {
		"on Call": ["Where are you, Neel ?"]
	},
	"Friends to me": {
		"on Whatsapp": ["Wassup, where are you bro?", "Where are you buddy?"],
		"on Messenger": ["Hey, in city?", "Hey, Call me I'm in City, We can meet"],
		"on Call": ["I'm at your Home, F*ck! where the hell are you?"]
	}
} ```

People were keep asking me where are you Neel, every time while I was working on a Interesting GIF making or some in house project in college hostel. I have a thought to make something which always track your location and tell this people where are you and that thing must be autonomous, that won't require your focus at all. So I come up with this.

### Stack
* Font end is Android app which keep tracks your location and update it into private cloud of Firebase.<br />
* Backend is a HTML page which fetches the live data from Firebase and update the Mapbox map in realtime.

### Version
1.0

### Installation

Setup the realtime DB in Firebase and connect it to the App and HTML page. 

### Development

Want to contribute? Great! Fork and send pull request.

### Todos

 - Adding more features Last updated time, Status : busy/available/don't disturb 
 - Making a Facebook/Telegram BOT which will use this data and reply people

License
----
MIT