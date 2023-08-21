// Demo data
var contacts = [
    { id: 1, name: "John Doe" },
    { id: 2, name: "Jane Smith" },
];

var chatRooms = {
    1: { name: "John Doe", messages: [] },
    2: { name: "Jane Smith", messages: [] },
};

// Create contact list
var contactsList = document.getElementById("contacts-list");
contacts.forEach(function (contact) {
    var listItem = document.createElement("a");
    listItem.href = "#";
    listItem.classList.add("list-group-item", "list-group-item-action");
    listItem.setAttribute("data-toggle", "list");
    listItem.textContent = contact.name;
    listItem.dataset.id = contact.id;

    listItem.addEventListener("click", loadChatRoom);

    contactsList.appendChild(listItem);
});

var currentRoomId = null;
var chatContainer = document.getElementById("chat-container");
var chatHeader = document.getElementById("chat-header");
var chatBody = document.getElementById("chat-body");
var messageInput = document.getElementById("message-input");
var messageForm = document.getElementById("message-form");

function loadChatRoom(event) {
    event.preventDefault();
    var roomId = event.currentTarget.dataset.id;
    var roomData = chatRooms[roomId];

    currentRoomId = roomId;
    chatHeader.textContent = roomData.name;
    chatBody.innerHTML = "";
    roomData.messages.forEach(function (message) {
        var messageElement = document.createElement("p");
        messageElement.textContent = message;
        chatBody.appendChild(messageElement);
    });

    chatContainer.style.display = 'flex';
}

messageForm.addEventListener("submit", function (event) {
    event.preventDefault();
    var messageText = messageInput.value;
    messageInput.value = "";

    var messageElement = document.createElement("p");
    messageElement.textContent = messageText;
    chatBody.appendChild(messageElement);

    chatRooms[currentRoomId].messages.push(messageText);

    // TODO: 스프링 서버로 요청 보내기 메소드 추가

});
