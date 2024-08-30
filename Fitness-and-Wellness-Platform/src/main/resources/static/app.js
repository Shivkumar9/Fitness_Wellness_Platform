async function registerUser(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const response = await fetch('/users/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, email, password }),
    });

    if (response.ok) {
        alert('User registered successfully!');
        window.location.href = '/home';
    } else {
        alert('Failed to register user.');
    }
}

// Function to handle workout submission
async function addWorkout(event) {
    event.preventDefault();
    const name = document.getElementById('workoutName').value;
    const description = document.getElementById('workoutDescription').value;
    const date = document.getElementById('workoutDate').value;

    const response = await fetch('/workouts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ name, description, date }),
    });

    if (response.ok) {
        alert('Workout added successfully!');
        window.location.reload();
    } else {
        alert('Failed to add workout.');
    }
}

// Attach event listeners to the forms
document.getElementById('registerForm').addEventListener('submit', registerUser);
document.getElementById('workoutForm').addEventListener('submit', addWorkout);
