# Where are you?

### Automate tracking and sharing your location with your friends and family.
![Where are you?](https://raw.githubusercontent.com/neelkadia/WhereaAreYou/master/screenshot_1.png)

### Why I made this?
```JSON
{
	"MOM to ME": {
		"on Call": ["Where are you, Neel ?"]
	},
	"Friends to me": {
		"on Whatsapp": ["Wassup, where are you bro?", "Where are you buddy?"],
		"on Messenger": ["Hey, in city?", "Hey, Call me I'm in City, We can meet"],
		"on Call": ["I'm at your Home, F*ck! where the hell are you?"]
	}
}
```
People kept asking me "Where are you Neel?!" constantly while I was working on a interesting GIF or some in-house project in a college hostel. I had a thought to make something which always track your location and tell these people where you are. That thing must be autonomous, so it won't require your focus at all. So I came up with this.

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
 - Adding [what3words](https://map.what3words.com/toddler.geologist.animated) address. This is a new way(it also open source) to share you addres in just three worlds (for exmaple, I'm at [typhoon.crystal.crust](https://map.what3words.com/typhoon.crystal.crust) 
 - Adding more features Last updated time, Status : busy/available/don't disturb 
 - Making a Facebook/Telegram BOT which will use this data and reply people

### License

MIT

### Donate via PayPal
[paypal.me/neelkadia](https://paypal.me/neelkadia)
