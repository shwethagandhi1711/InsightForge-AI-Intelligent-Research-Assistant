// This event listener waits until the HTML document is completely loaded
// DOMContentLoaded ensures all elements are available before accessing them
document.addEventListener('DOMContentLoaded', () => {

    // chrome.storage.local.get is used to retrieve data stored in Chrome Extension local storage
    // Here, we are trying to get previously saved research notes using the key 'researchNotes'
    chrome.storage.local.get(['researchNotes'], function(result) {

       // Check if researchNotes exist in storage
       if (result.researchNotes) {

        // If notes exist, set them inside the textarea with id="notes"
        // This allows the user to see their previously saved notes
        document.getElementById('notes').value = result.researchNotes;
       } 
    });

    // Add click event listener to Summarize button
    // When user clicks summarizeBtn, summarizeText function will execute
    document.getElementById('summarizeBtn').addEventListener('click', summarizeText);

    // Add click event listener to Save Notes button
    // When user clicks saveNotesBtn, saveNotes function will execute
    document.getElementById('saveNotesBtn').addEventListener('click', saveNotes);
});


// Async function used to summarize selected text from the current webpage
async function summarizeText() {

    try {

        // chrome.tabs.query is used to get details of the currently active tab
        // active:true → currently active tab
        // currentWindow:true → current browser window
        const [tab] = await chrome.tabs.query({ active:true, currentWindow: true});


        // chrome.scripting.executeScript injects and executes JavaScript inside the webpage
        // Here, it runs window.getSelection().toString()
        // This gets the text selected by the user on the webpage
        const [{ result }] = await chrome.scripting.executeScript({

            // Specify which tab to execute script
            target: {tabId: tab.id},

            // Function executed inside webpage
            function: () => window.getSelection().toString()
        });


        // If no text is selected, show message to user
        if (!result) {

            // showResult displays message in extension popup
            showResult('Please select some text first');

            // Stop execution
            return;
        }


        // Send selected text to backend API (Spring Boot)
        // fetch is used to make HTTP POST request
        const response = await fetch('http://localhost:8080/api/research/process', {

            // HTTP method
            method: 'POST',

            // Tell server data is JSON
            headers: { 'Content-Type': 'application/json' },

            // Send selected text and operation type
            // operation: summarize tells backend what to do
            body: JSON.stringify({
                content: result,
                operation: 'summarize'
            })
        });


        // If API returns error (like 500, 404 etc)
        if (!response.ok) {

            // Throw error with status code
            throw new Error(`API Error: ${response.status}`);
        }


        // Get response text from backend
        const text = await response.text();


        // Replace newline characters with <br>
        // This keeps formatting in HTML
        showResult(text.replace(/\n/g,'<br>'));


    } catch (error) {

        // If any error occurs, display error message
        showResult('Error: ' + error.message);
    }
}



// Function to save notes entered by user
async function saveNotes() {

    // Get notes from textarea
    const notes = document.getElementById('notes').value;


    // Save notes into Chrome Extension local storage
    chrome.storage.local.set({ 'researchNotes': notes}, function() {

        // Show success message after saving
        alert('Notes saved successfully');
    });
}



// Function to display results inside extension popup
function showResult(content) {

    // Set HTML inside element with id="results"
    // This displays summarized content or error message
    document.getElementById('results').innerHTML =

    // result-item and result-content are CSS classes used for styling
    `<div class="result-item">
        <div class="result-content">${content}</div>
     </div>`;
}