# SemesterV-MAD-M2-Practice

## List View:

```Java
ListView listview = findViewById(R.id.MainPgListView);

        String[] listviewdetails = {
                "Web View",
                "Camera View (Photo)",
                "Camera View (Video)",
                "Date Picker",
                "Time Picker",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listviewdetails);
        listview.setAdapter(adapter);
```

## Web View:

Add this in the manifest file: 
`<uses-permission android:name="android.permission.INTERNET"/>`

```Java
WebView webView = findViewById(R.id.WebViewPg2);
webView.loadUrl("https://www.splunk.com/en_us/about-splunk/contact-us.html#customer-support");
```

## Opening Camera in order to take a picture and display it:

```Java
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_picture);
        imageView = findViewById(R.id.imageView);
    }
    public void clickPicture(View view){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100 && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
        else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
```

## Opening Camera in order to take a video and display it:

```Java

  VideoView videoView; // Inside clickVideo Class
  videoView = findViewById(R.id.videoViewpg3); // Inside onCreate

  public void clickVideo(View view) {
        Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(i, 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            videoView.setVideoURI(videoUri);
            videoView.start();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

```
## Selecting Date and Displaying it on same Page:

```Java
String setDate; // Inside DatePicker Class
TextView date; // Inside DatePicker Class
    
date = findViewById(R.id.dateSelected); // Inside onCreate

public void datePickeronClick(View view) {
        MaterialDatePicker<Long> materialDatePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
            @Override
            public void onPositiveButtonClick(Long selection) { // Type "new" within the Round Brackets for this function
                setDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date(selection));
                date.setText(setDate);
            }
        });
        materialDatePicker.show(getSupportFragmentManager(), "tag");
    }
```
## Selecting Time and Displaying it on another Page:

```Java
String setTime; // Inside TimePicker Class
TextView time; // Inside TimePicker Class

time = findViewById(R.id.timeSelected); // Inside onCreate

public void timePickeronClick(View view) {
        MaterialTimePicker timePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setInputMode(MaterialTimePicker.INPUT_MODE_CLOCK)
                .setTitleText("Select Time")
                .build();
        timePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTime = MessageFormat.format("{0}:{1}",
                        String.format(Locale.getDefault(), "%02d", timePicker.getHour()),
                        String.format(Locale.getDefault(), "%02d", timePicker.getMinute()));
                time.setText(setTime);
            }
        });
        timePicker.show(getSupportFragmentManager(), "tag");
    }

  public void goToNextPage(View view) {
        Intent i = new Intent(TimePickerActivity.this, TimePickerActivityPg2.class);
        i.putExtra("time", setTime);
        startActivity(i);
    }
// Code to add time to page 2
        TextView Time; // Inside TimePickerPg2 Class
        // Inside onCreate
        Time = findViewById(R.id.selectedTime);

        Bundle bundle = getIntent().getExtras();
        String time = bundle.getString("time");

        Time.setText(time);
```
