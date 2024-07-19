document.addEventListener("DOMContentLoaded", function() {
    // Get the button element by its ID
    var deleteButton = document.getElementById("deleteButton");
    
    // Attach a click event handler to the button
    deleteButton.addEventListener("click", function() {
        // Display an alert when the button is clicked
        alert("Your account has been deleted");
    });
});