// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// this file will run once on extension load

var config = {
  apiKey: "secret-here",
  authDomain: "secret-here",
  databaseURL: "secret-here",
  projectId: "secret-here",
  storageBucket: "secret-here",
  messagingSenderId: "secret-here"
};
const app = firebase.initializeApp(config);
const appDb = app.database().ref();

var urlRef = appDb.child("geometry/coordinates");
urlRef.once("value", function(snapshot) {
  snapshot.forEach(function(child) {
    console.log(child.key+": "+child.val());
  });
});

window.onload = function() {
  var refreshId = setInterval(getLocation, 30 * 60 * 1000); // Every 30 mins it will update location
  console.log(refreshId);
};

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        console.log("Geolocation is not supported by this browser.");
        //x.innerHTML = "Geolocation is not supported by this browser.";
    }
}
function showPosition(position) {
	console.log("Latitude: " + position.coords.latitude + " Longitude: " + position.coords.longitude);
	urlRef.update({ 0: position.coords.latitude });
	urlRef.update({ 1: position.coords.longitude });
	urlRef.update({ 2: Date.now() });
}