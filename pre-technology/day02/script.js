const form = document.getElementById("registrationForm");
const modal = document.getElementById("dataModal");
const modalBody = document.getElementById("modalBody");
const closeModalBtn = document.getElementById("closeModal")

form.addEventListener('submit', (e) => {
  e.preventDefault();

  if (validateForm()) {
    showModal();
  };
})

closeModalBtn.addEventListener("click", () => {
  modal.style.display = "none";
})

const showModal = () => {
  const fullName = document.getElementById('fullname').value;
  const email = document.getElementById('email').value;
  const password = document.getElementById('password').value;
  const gender = document.querySelector('input[name="gender"]:checked').value;
  const languages = Array.from(document.querySelectorAll('input[name="languages"]:checked')).map(lang => lang.value);
  const country = document.getElementById('country').value;
  const reason = document.getElementById('reason').value;

  const content = `
    <p><strong>Full Name:</strong> ${fullName}</p>
    <p><strong>Email:</strong> ${email}</p>
    <p><strong>Password:</strong> ${'*'.repeat(password.length)}</p>
    <p><strong>Gender:</strong> ${gender}</p>
    <p><strong>Known Languages:</strong> ${languages.join(', ') || 'None'}</p>
    <p><strong>Country:</strong> ${country}</p>
    <p><strong>Reason:</strong> ${reason}</p>
  `
  modalBody.innerHTML = content;
  modal.style.display = "flex";
}

const validateForm = () => {
  const fullName = document.getElementById('fullname').value.trim();
  const email = document.getElementById('email').value.trim();
  const password = document.getElementById('password').value.trim();
  const gender = document.querySelector('input[name="gender"]:checked');
  const reason = document.getElementById('reason').value.trim();

  if (!fullName) {
    alert('Full Name is required.');
    return false;
  }
  if (!validateEmail(email)) {
    alert('Please enter a valid email.');
    return false;
  }
  
  const passwordErrors = validatePassword(password);
  if (passwordErrors) {
    alert(passwordErrors);
    return false;
  }

  if (!gender) {
    alert('Please select a gender.');
    return false;
  }
  if (!reason) {
    alert('Reason is required.');
    return false;
  }
  return true;
}

const validateEmail = (email) => {
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}

const validatePassword = (password) => {
  const errors = [];

  if (password.length < 8) {
    errors.push('Password must be at least 8 characters long.');
  }
  if (!/[A-Z]/.test(password)) {
    errors.push('Password must contain at least one uppercase letter.');
  }
  if (!/[a-z]/.test(password)) {
    errors.push('Password must contain at least one lowercase letter.');
  }
  if (!/\d/.test(password)) {
    errors.push('Password must contain at least one number.');
  }
  if (!/[@$!%*?&#_]/.test(password)) {
    errors.push('Password must contain at least one special character (@, $, !, %, *, ?, &, #, or _).');
  }

  return errors.length > 0 ? errors.join("\n") : null;
}