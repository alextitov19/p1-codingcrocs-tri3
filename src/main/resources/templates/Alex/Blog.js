
// Firebase App (the core Firebase SDK) is always required and must be listed first
import firebase from "firebase/app";
// If you are using v7 or any earlier version of the JS SDK, you should import firebase using namespace import
// import * as firebase from "firebase/app"


var mainText = document.getElementById("mainText");
var submitButton = document.getElementById("submitButton");

function submitClick() {

    // Get a reference to the root of the Database
    var database = firebase.database();
    writeUserData("someID", "someName", "someEmail", "someURL")

}

function writeUserData(userId, name, email, imageUrl) {
    firebase.database().ref('users/' + userId).set({
        username: name,
        email: email,
        profile_picture : imageUrl
    });
}