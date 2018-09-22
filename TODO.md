# Trisolve
Triangle Solver Android App TODO list  


Primary Color Blue 500

"Variable"/"Constant" toggle state on label followed by Edittext.  

Entering data changes edittext to "Constant".  
Changing toggle state to "Variable" clears data and attempts to calculate.  
Toggle state disabled and "Variable" iff empty.  

Global Clear Button
Normalize Functionality (Side A on bottom, radius 1, center at 0,0)

Side, Angle:  

| BC |, /_ A  
| AC |, /_ B  
| AB |, /_ C  

Allow AAA to default to R == 1.0.
Allow ASS to have 2 solutions.


x, y:

Ax, Ay
Bx, By
Cx, Cy


Theta, Radius, Center:

Theta A  
Theta B  
Theta C  
Radius  
X Center  
Y Center  


Drawing Tab:

Vertex drawing gestures depend on coordinate system:
- side, angle: Side changes with 2 linear guides. Angle changes with 2 circular guides.
- x, y: 2 guides in the cardinal directions.
- r, theta: 2 guides in radial and rotational directions.

Transform Gestures:
Translate long press drag.
Rotate with 2 finger spin motion.
Reflect with 2 finger swipe motion.
Dialate with 2 finger pinch/expand.

Menu Transform:  Implement as "Action Provider". (fields) are optional.

- Translate, x, y
- Rotate, Theta, (x, y)
- Reflect, (Theta, (x, y))
- Dilate, factor, (x, y)

Menu Coordinates:
Indicate which one is selected:
    - side, angle (dimension)
    - x, y (cartesian)
    - r, theta (polar)

Menu Overflow:
- Settings
- Help

Dimensions:  

height A  
height B  
height C  
perimeter  
area  


Settings Activity:

- Angle Units: Degrees, Radians, Gradians, deg:mm':ss", Ns

- Precision: 1, 0.1, 0.01, 0.001, 0.0001, 0.00001



----

Proposed Enhancements:

Create a Length and Angle Picker dialog.  Much like https://developer.android.com/reference/android/app/DatePickerDialog.

Optional lettering/Colors indicating sides and angles.

Normalize action, transform triangle to unit circle with base == | BC |

Gather usage statistics

Save, Restore

Persist current triangle across reboot.

Paid/Free versions.

Animate or otherwise highlight the current coordinate system selection in the menu.

