# Potato Disease Detection and Classification System

The Potato Disease Detection and Classification System is an innovative and user-friendly web application designed to assist farmers in identifying and classifying diseases in potato plant leaves. Leveraging state-of-the-art Keras models, the application accurately detects and classifies the health condition of potato leaves, providing vital information to farmers. The system is deployed as a service on Google Cloud Platform (GCP) and accessed through a React.js application, allowing users to upload images of potato leaves to determine if they are healthy or diseased, and identify the specific disease.

## Features

* **State-of-the-Art Model**: Utilizes advanced Keras models for accurate detection and classification of potato leaf diseases.
* **User-Friendly Interface**: A clean and intuitive React.js interface for easy image upload and disease identification.
* **Cloud Deployment**: The model is deployed as a service on GCP, ensuring high availability and scalability.
* **Real-Time Results**: Provides immediate feedback on the health status of the potato leaf and the specific disease if present.
* **Farmer-Friendly Solution**: Designed to help farmers reduce crop loss and improve productivity by providing timely and accurate disease diagnosis.

## Technologies Used

* **React**: Core logic of the web application for handling user interactions and dynamic updates.
* **JavaScript**: Handles various functionalities and API requests.
* **HTML/CSS**: Provides structure and styles for the web application, offering an aesthetically pleasing and responsive design.
* **Keras/TensorFlow**: Model building for image classification and disease detection.
* **GCP**: Deployment of the model as a service for high availability and scalability.
* **FASTAPI**: Backend server and API management for handling image upload and model inference.

## How It Works

### User Interface
1. **Image Upload**: Users can upload images of potato leaves through the React.js interface.
2. **Disease Detection**: The application queries the GCP-deployed model to detect and classify the disease.
3. **Result Display**: The application displays the health status of the leaf and the specific disease, if any.

### GCP Service
1. **Model Deployment**: The trained Keras model is deployed as a service on GCP using TensorFlow Serving and FASTAPI.
2. **Image Processing**: The service processes the uploaded image and performs inference using the deployed model.
3. **Result Communication**: The service returns the classification result to the React.js application for display.

## Model Performance

The performance of the model is evaluated using various metrics to ensure its accuracy and reliability. The table below presents the performance metrics:

| Metric      | Value   |
|-------------|---------|
| Accuracy    | 91%     |
| AUC         | 0.93    |
| F1 Score    | 0.88    |

## Setup

### GCP Service

1. **Clone the Repository**:
    ```bash
    https://github.com/hungrycarpet/Machine-Learning-Deep-Learning-Projects.git
    ```

2. **Navigate to the Project Directory**:
    ```bash
    cd Potato-Disease-Detection/
    ```

3. **Deploying the TF Model (.h5) on GCP**:
  ```bash
  a. Create a [GCP account](https://console.cloud.google.com/freetrial/signup/).
  b. Create a [Project on GCP](https://cloud.google.com/appengine/docs/standard/nodejs/building-app/creating-project).
  c. Create a [GCP bucket](https://console.cloud.google.com/storage/browser/).
  d. Upload the tf .h5 model generate in the bucket in the path `models/potatoes.h5`.
  e. Install Google Cloud SDK ([Setup instructions](https://cloud.google.com/sdk/docs/quickstarts)).
  f. Authenticate with Google Cloud SDK: gcloud auth login
  g. Run the deployment script.
  cd gcp
  gcloud functions deploy predict --runtime python38 --trigger-http --memory 512 --project project_id

  
  h. Your model is now deployed.
  i. Use Postman to test the GCF using the [Trigger URL](https://cloud.google.com/functions/docs/calling/http).
  ```

### React.js Website

1. **Navigate to the Frontend Directory**:
    ```bash
    cd frontend
    ```

2. **Install Dependencies**:
    ```bash
    npm install
    ```

3. **Start the Application**:
    ```bash
    npm run start
    ```

## Project Structure of Reactjs Website

* `src/`: Contains all the source code, including components, services, and styles for the React.js application.
* `public/`: Contains the public assets and the main `index.html` file.
* `index.html`: The entry point for the web application.
* Other typical project files like `package.json`, `.gitignore`, etc.

## Screenshots

![Potato Disease Detection Interface](assets/screenshot.png "Potato Disease Detection Interface")

## Contact

For any queries or feedback, please contact me at ***manasparasar@gmail.com***

## License

MIT License

Copyright (c) 2019 Manas Mishra

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
