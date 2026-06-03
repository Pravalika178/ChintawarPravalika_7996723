console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
    alert("Welcome to the Community Portal");
    loadPreference();
    displayEvents();
});

const eventName = "Community Music Festival";
const eventDate = "2026-07-15";
let availableSeats = 50;

console.log(`${eventName} on ${eventDate} | Seats: ${availableSeats}`);

function validatePhone() {
    const phone = document.getElementById("phone");

    if (!phone) return;

    const pattern = /^[0-9]{10}$/;

    if (phone.value !== "" && !pattern.test(phone.value)) {
        alert("Enter a valid 10-digit phone number");
        phone.focus();
    }
}

function showFee() {
    const eventType = document.getElementById("eventType");
    const feeDisplay = document.getElementById("feeDisplay");

    if (!eventType || !feeDisplay) return;

    const fees = {
        Music: "₹500",
        Food: "₹300",
        Workshop: "₹700"
    };

    feeDisplay.textContent =
        eventType.value ? `Event Fee: ${fees[eventType.value]}` : "";

    localStorage.setItem("preferredEvent", eventType.value);
}

function showConfirmation() {
    console.log("Registration button clicked");
}

function videoReady() {
    const status = document.getElementById("videoStatus");

    if (status) {
        status.textContent = "Video ready to play";
    }
}

const form = document.getElementById("eventForm");

if (form) {
    form.addEventListener("submit", function (event) {
        event.preventDefault();

        const name = document.getElementById("name").value;
        const output = document.getElementById("outputMessage");

        if (output) {
            output.value = `Thank you ${name}. Registration submitted successfully.`;
        }

        sendRegistration();
    });
}

const messageBox = document.getElementById("message");

if (messageBox) {
    messageBox.addEventListener("keyup", () => {
        const count = document.getElementById("charCount");

        if (count) {
            count.textContent = messageBox.value.length;
        }
    });
}

document.querySelectorAll(".eventImage").forEach(image => {
    image.ondblclick = function () {
        if (this.style.transform === "scale(1.8)") {
            this.style.transform = "scale(1)";
        } else {
            this.style.transform = "scale(1.8)";
        }
    };
});

window.onbeforeunload = function () {
    const nameField = document.getElementById("name");

    if (nameField && nameField.value !== "") {
        return "Unsaved form data may be lost.";
    }
};

const geoButton = document.getElementById("geoBtn");

if (geoButton) {
    geoButton.addEventListener("click", () => {

        if (!navigator.geolocation) {
            alert("Geolocation not supported");
            return;
        }

        navigator.geolocation.getCurrentPosition(
            position => {
                document.getElementById("locationResult").innerHTML =
                    `Latitude: ${position.coords.latitude}<br>
                     Longitude: ${position.coords.longitude}`;
            },
            error => {
                switch (error.code) {
                    case error.PERMISSION_DENIED:
                        alert("Location permission denied");
                        break;

                    case error.TIMEOUT:
                        alert("Location request timed out");
                        break;

                    default:
                        alert("Unable to retrieve location");
                }
            },
            {
                enableHighAccuracy: true,
                timeout: 10000,
                maximumAge: 0
            }
        );
    });
}

function savePreference() {
    const eventType = document.getElementById("eventType");

    if (!eventType) return;

    localStorage.setItem("preferredEvent", eventType.value);
    sessionStorage.setItem("sessionEvent", eventType.value);

    alert("Preference Saved");
}

function loadPreference() {
    const saved = localStorage.getItem("preferredEvent");
    const eventType = document.getElementById("eventType");

    if (saved && eventType) {
        eventType.value = saved;
        showFee();
    }
}

const saveBtn = document.getElementById("savePreference");

if (saveBtn) {
    saveBtn.addEventListener("click", savePreference);
}

const clearBtn = document.getElementById("clearPreference");

if (clearBtn) {
    clearBtn.addEventListener("click", () => {
        localStorage.clear();
        sessionStorage.clear();
        alert("Preferences Cleared");
    });
}

class EventPortal {
    constructor(name, category, seats) {
        this.name = name;
        this.category = category;
        this.seats = seats;
    }
}

EventPortal.prototype.checkAvailability = function () {
    return this.seats > 0;
};

const events = [
    new EventPortal("Music Festival", "Music", 50),
    new EventPortal("Food Carnival", "Food", 30),
    new EventPortal("Community Workshop", "Workshop", 20)
];

Object.entries(events[0]).forEach(entry => {
    console.log(entry[0], entry[1]);
});

function addEvent(event) {
    events.push(event);
}

function registerUser(eventObj) {
    try {
        if (eventObj.seats <= 0) {
            throw new Error("No seats available");
        }

        eventObj.seats--;
        availableSeats--;

        displayEvents();

    } catch (error) {
        console.error(error.message);
        alert(error.message);
    }
}

function filterEventsByCategory(category, callback) {
    const result = events.filter(
        event => category === "all" || event.category === category
    );

    callback(result);
}

function registrationTracker(category) {
    let count = 0;

    return function () {
        count++;
        console.log(`${category} registrations: ${count}`);
    };
}

const musicTracker = registrationTracker("Music");

function displayEvents(list = events) {

    const eventSection = document.getElementById("events");

    if (!eventSection) return;

    document.querySelectorAll(".dynamicCard").forEach(card => card.remove());

    list.forEach(event => {

        if (!event.checkAvailability()) return;

        const card = document.createElement("div");

        card.className = "eventCard dynamicCard";

        card.innerHTML = `
            <h3>${event.name}</h3>
            <p>Category: ${event.category}</p>
            <p>Seats: ${event.seats}</p>
            <button>Register</button>
        `;

        card.querySelector("button").onclick = () => {

            registerUser(event);

            if (event.category === "Music") {
                musicTracker();
            }
        };

        eventSection.appendChild(card);
    });
}

const categoryFilter = document.getElementById("filterCategory");

if (categoryFilter) {

    categoryFilter.onchange = function () {

        filterEventsByCategory(this.value, result => {
            displayEvents(result);
        });
    };
}

const searchBox = document.getElementById("quickSearch");

if (searchBox) {

    searchBox.addEventListener("keydown", () => {

        const keyword = searchBox.value.toLowerCase();

        const filtered = events.filter(event =>
            event.name.toLowerCase().includes(keyword)
        );

        displayEvents(filtered);
    });
}

const musicEvents = events.filter(
    event => event.category === "Music"
);

console.log(musicEvents);

const formattedEvents = events.map(
    event => `Workshop on ${event.name}`
);

console.log(formattedEvents);

const copiedEvents = [...events];

console.log(copiedEvents);

async function fetchEventsAsync() {

    try {

        const response = await fetch(
            "https://jsonplaceholder.typicode.com/posts"
        );

        const data = await response.json();

        console.log(data.slice(0, 5));

    } catch (error) {

        console.error(error);
    }
}

fetchEventsAsync();

fetch("https://jsonplaceholder.typicode.com/users")
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error(error));

function sendRegistration() {

    const form = document.getElementById("eventForm");

    if (!form) return;

    const data = {
        name: form.elements["name"]?.value || "",
        email: form.elements["email"]?.value || "",
        event: form.elements["eventType"]?.value || ""
    };

    setTimeout(() => {

        fetch("https://jsonplaceholder.typicode.com/posts", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(result => {
                console.log("Success", result);
            })
            .catch(error => {
                console.error("Failed", error);
            });

    }, 1000);
}

$(document).ready(function () {

    $(".eventCard").hide().fadeIn(1000);

    $("#registerBtn").click(function () {
        $(".eventCard").fadeOut(500).fadeIn(500);
    });
});

function getEventDetails(
    { name = "Unknown", category = "General", seats = 0 } = {}
) {
    console.log(name, category, seats);
}

getEventDetails(events[0]);