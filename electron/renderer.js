const information = document.getElementById('info')
console.log(window);
window.versions.cpu().then(data => information.innerText = data.brand);