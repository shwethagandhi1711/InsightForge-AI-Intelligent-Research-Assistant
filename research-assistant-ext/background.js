// chrome.sidePanel API is used to control the Chrome Extension Side Panel behavior

// setPanelBehavior() method is used to configure how the side panel should open

chrome.sidePanel.setPanelBehavior({

    // openPanelOnActionClick: true means:
    // When the user clicks on the extension icon in the Chrome toolbar,
    // the side panel will automatically open

    // "action click" refers to clicking the extension icon

    // If this is true → side panel opens automatically
    // If this is false → you must open side panel manually using code

    openPanelOnActionClick: true

});