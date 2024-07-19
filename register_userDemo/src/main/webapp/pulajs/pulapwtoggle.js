function togglePasswordVisibility() {
    var passwordInput = document.getElementById("upw2");
    var showButton = document.getElementById("show");

    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        showButton.textContent = "Hide";
    } else {
        passwordInput.type = "password";
        showButton.textContent = "Show";
    }
}
