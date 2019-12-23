# SnackBarApp  

<p float="left">
  <img src="https://material.io/develop/images/content/f2ec5451582a06af5eb20e3dfb3d27d5.svg" height="340" width="400" />
  <img src="https://androidexample365.com/content/images/2018/06/Light.jpg"  height="390" width="400" /> 
</p>

The Snackbar widget provides brief feedback about an operation through a message at the bottom of the screen. Snackbars disappear automatically, either after a timeout or after a user interaction elsewhere on the screen, and can also be swiped off the screen.  
Snackbars can also offer the ability to perform an action, such as undoing an action that was just taken, or retrying an action that had failed.  

**NOTE**: Snackbars work best if they are displayed inside of a `CoordinatorLayout`. CoordinatorLayout allows the snackbar to enable behavior like swipe-to-dismiss, as well as automatically moving widgets like FloatingActionButton.  

Showing a snackbar with just a message and no action would look like this:  

// The view used to make the snackbar. This should be contained within the view  
// hierarchy you want to display the snackbar. Generally it can be the view that  
// was interacted with to trigger the snackbar, such as a button that was  
// clicked, or a card that was swiped.  

```java
View contextView = findViewById(R.id.context_view);
Snackbar.make(contextView, R.string.item_removed_message, Snackbar.LENGTH_SHORT).show();
```
- **Adding an action**  

To add an action, use the setAction method on the object returned from make. Actions require both text to display, and an `OnClickListener` to handle clicks on the action. Snackbars are automatically dismissed when the action is clicked.  

Showing a snackbar with a message and an action would look like this:  
```java
Snackbar.make(contextView, R.string.item_removed_message, Snackbar.LENGTH_LONG).setAction(R.string.undo, new OnClickListener() {

@Override
public void onClick(View v) {
// Respond to the click, such as by undoing the modification that caused
// this message to be displayed
 })
 });
```

