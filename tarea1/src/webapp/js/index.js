document.addEventListener("DOMContentLoaded", function() {
    var loginModal = new bootstrap.Modal(document.getElementById('loginModal'), {});
    var registerModal = new bootstrap.Modal(document.getElementById('registerModal'), {});

    document.getElementById("loginButton").addEventListener("click", function() {
        loginModal.show();
    });

    document.getElementById("registerButton").addEventListener("click", function() {
        registerModal.show();
    });
});
