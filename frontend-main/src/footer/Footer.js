import React, {Component} from 'react';
import './Footer.css';

class Footer extends Component {
  constructor(props) {
    super(props);
    this.state = {
      code: props.code ? props.code : '999',
      description: props.description ? props.description : 'Unknown error'
    }
  }

  render() {
    const {code, description} = this.state;
    return (
        <footer class="site-footer">
          <div class="container">
            <div class="row">
              <div class="col-sm-12 col-md-7">
                <svg viewBox="0 0 280 280" height="210" width="210" className="translated-logo">
                  <g transform="matrix(1,0,0,1,107.23121895307692,90.50252531694167)">
                    <svg viewBox="0 0 65.53756209384616 98.99494936611664" height="98.99494936611664"
                         width="65.53756209384616">
                      <g>
                        <svg xmlns="http://www.w3.org/2000/svg" xmlnsXlink="http://www.w3.org/1999/xlink" version="1.1" x="0" y="0" viewBox="24.761856079101562 5 59.5826416015625 90" enableBackground="new 0 0 100 100" xmlSpace="preserve" height="98.99494936611664" width="65.53756209384616" className="icon-o-0" data-fill-palette-color="accent" id="o-0"><g fill="#35185a" data-fill-palette-color="accent"><path d="M73.76 35.603C86.875 48 91.5 66.25 65.633 82.379c3.64-4.928 5.654-9.794 6.096-14.669 0.951-10.516-5.606-19.072-12.835-26.752C48.298 29.7 47.51 18.84 56.413 6.782 54.578 22.641 64.6 26.944 73.76 35.603zM45.288 93.716c6.184-13.053 7.276-20.302-8.197-34.939-4.204-3.977-7.451-8.029-9.71-12.086-2.881 6.435-5.164 20.081 3.244 27.935C36.312 79.938 44.125 83.125 45.288 93.716zM56.709 43.014C48.183 33.954 41.999 21.253 54 5 21.497 17.692 19.625 38.125 39.151 56.597 55.603 72.158 54.75 80.75 48 95 79.875 71.5 68.709 55.764 56.709 43.014z" fill="#35185a" data-fill-palette-color="accent"></path></g><g
                          display="none" fill="#35185a" data-fill-palette-color="accent"><path display="inline" d="M54 5C16.75 17.5 14.875 56.5 26.75 70.762c10.558 12.68 15.407 7.949 19.675 20.824" fill="#35185a" data-fill-palette-color="accent"></path>
                          <line display="inline" x1="56.988" y1="5.261" x2="45.528" y2="136.262"
                                fill="#35185a" data-fill-palette-color="accent"></line>
                          <line display="inline" x1="54.131" y1="3.502" x2="42.67" y2="134.502" fill="#35185a"
                                data-fill-palette-color="accent"></line>
                          <path display="inline" d="M42.875 76" fill="#35185a"
                                data-fill-palette-color="accent"></path></g></svg>
                      </g>
                    </svg>
                  </g>
                  <path
                    d="M37.197 173.603l1.782 4.453c-0.741 0.946-1.671 2.042-2.791 3.289-1.126 1.249-2.315 2.535-3.569 3.857-1.251 1.328-2.529 2.66-3.835 3.995-1.314 1.332-2.526 2.562-3.635 3.691v0c1.58 0.045 3.302 0.09 5.167 0.135 1.861 0.054 3.703 0.129 5.525 0.227 1.82 0.092 3.568 0.201 5.245 0.329 1.671 0.13 3.101 0.281 4.289 0.454v0l1.738 4.343c-1.839 1-3.806 2.037-5.9 3.11-2.088 1.071-4.237 2.145-6.444 3.222-2.208 1.076-4.433 2.145-6.675 3.207-2.242 1.062-4.438 2.08-6.586 3.054v0l-1.893-4.73c3.034-1.329 6.148-2.714 9.343-4.157 3.201-1.445 6.27-2.917 9.208-4.414v0c-0.697-0.049-1.531-0.1-2.501-0.154-0.964-0.056-2.008-0.109-3.133-0.158-1.125-0.049-2.283-0.092-3.474-0.128-1.2-0.04-2.36-0.079-3.48-0.115-1.12-0.037-2.163-0.068-3.13-0.095-0.972-0.024-1.801-0.046-2.486-0.064v0l-1.435-3.586c0.483-0.486 1.074-1.075 1.773-1.769 0.693-0.691 1.432-1.436 2.218-2.236 0.783-0.805 1.596-1.634 2.439-2.485 0.837-0.849 1.64-1.676 2.408-2.483 0.766-0.813 1.484-1.575 2.155-2.285 0.677-0.713 1.24-1.32 1.689-1.821v0c-3.162 0.938-6.398 1.991-9.71 3.16-3.308 1.16-6.519 2.303-9.635 3.429v0l-1.89-4.72c2.227-0.778 4.537-1.563 6.93-2.357 2.392-0.794 4.77-1.571 7.132-2.331 2.371-0.757 4.676-1.466 6.915-2.126 2.239-0.661 4.32-1.241 6.246-1.741zM38.859 235.07l-11.456-15.477 22.868-16.928 10.871 14.687-3.528 2.612-7.793-10.529-5.643 4.178 6.936 9.37-3.464 2.565-6.936-9.371-6.705 4.963 8.378 11.318zM44.676 240.747l20.087-20.15 3.665 3.653-20.088 20.149zM81.463 238.152v0c-2.417-1.661-4.777-2.178-7.08-1.551-2.308 0.623-4.375 2.263-6.201 4.92v0c-0.87 1.266-1.512 2.528-1.926 3.785-0.414 1.258-0.581 2.464-0.5 3.621 0.09 1.155 0.436 2.247 1.036 3.279 0.604 1.026 1.507 1.951 2.707 2.776v0c0.742 0.51 1.402 0.923 1.979 1.24 0.578 0.317 1.057 0.537 1.437 0.662v0l5.788-8.422 4.264 2.931-7.74 11.261c-0.741-0.172-1.905-0.606-3.49-1.302-1.584-0.687-3.29-1.659-5.119-2.915v0c-1.691-1.162-3.05-2.494-4.075-3.994-1.027-1.509-1.673-3.118-1.937-4.826-0.27-1.712-0.155-3.509 0.343-5.391 0.493-1.886 1.415-3.812 2.765-5.776v0c1.346-1.959 2.839-3.488 4.477-4.587 1.633-1.103 3.331-1.82 5.094-2.151 1.76-0.341 3.525-0.301 5.292 0.119 1.768 0.42 3.443 1.173 5.026 2.261v0c1.08 0.742 1.993 1.478 2.737 2.207 0.744 0.729 1.36 1.393 1.848 1.992 0.487 0.6 0.858 1.136 1.112 1.608 0.254 0.472 0.428 0.809 0.523 1.01v0l-3.681 2.604c-0.395-0.874-0.997-1.798-1.807-2.772-0.813-0.968-1.77-1.831-2.872-2.589zM106.575 257.819l4.076-10.615 4.83 1.854-10.198 26.561-4.831-1.854 4.518-11.765-11.533-4.428-4.517 11.764-4.831-1.854 10.199-26.561 4.83 1.854-4.076 10.615zM135.273 280l-19.092-2.507 3.705-28.21 18.117 2.38-0.572 4.352-12.987-1.706-0.914 6.961 11.559 1.518-0.561 4.274-11.559-1.518-1.087 8.27 13.962 1.834zM167.633 277.292l-4.37 0.405c-1.074-1.47-2.263-3.042-3.569-4.716-1.313-1.68-2.666-3.37-4.06-5.069-1.394-1.699-2.803-3.341-4.226-4.924-1.43-1.59-2.779-3.014-4.046-4.273v0l1.879 20.281-5.073 0.47-2.624-28.33 4.212-0.391c1.194 1.046 2.493 2.292 3.897 3.738 1.398 1.453 2.808 2.965 4.23 4.535 1.423 1.577 2.806 3.161 4.15 4.752 1.344 1.591 2.546 3.082 3.606 4.473v0l-1.743-18.808 5.113-0.473zM184.944 240.658v0c3.724-1.726 6.89-2.365 9.499-1.918 2.605 0.456 4.557 2.087 5.857 4.892v0c1.623 3.502 0.999 6.674-1.873 9.515v0c0.733 0.353 1.586 0.801 2.56 1.342 0.982 0.545 2.004 1.151 3.065 1.82 1.061 0.668 2.11 1.372 3.145 2.11 1.038 0.745 2.007 1.496 2.906 2.255v0l-5.253 2.434c-0.889-0.675-1.818-1.339-2.785-1.993-0.967-0.654-1.927-1.278-2.881-1.872-0.957-0.6-1.881-1.153-2.772-1.659-0.897-0.504-1.721-0.943-2.471-1.317v0c-0.337 0.185-0.629 0.335-0.876 0.449-0.252 0.117-0.49 0.227-0.712 0.33v0l-2.27 1.052 4.523 9.758-4.695 2.176-11.793-25.445c1.027-0.775 2.167-1.504 3.42-2.186 1.25-0.689 2.385-1.27 3.406-1.743zM187.161 244.567v0c-0.991 0.459-1.893 0.921-2.707 1.386v0l3.867 8.343 2.045-0.948c1.147-0.532 2.124-1.061 2.931-1.588 0.815-0.524 1.439-1.083 1.871-1.677 0.432-0.594 0.672-1.235 0.719-1.921 0.047-0.686-0.124-1.449-0.514-2.29v0c-0.367-0.793-0.828-1.393-1.382-1.8-0.554-0.407-1.185-0.644-1.894-0.71-0.709-0.065-1.48 0.011-2.313 0.229-0.83 0.224-1.705 0.549-2.623 0.976zM196.946 235.071l17.946-13.903 2.743 3.54-6.917 5.358 14.682 18.951-4.121 3.193-14.682-18.951-6.908 5.353zM222.611 218.393l15.173 12.832c0.217-0.215 0.489-0.506 0.815-0.872 0.326-0.366 0.765-0.874 1.317-1.526v0c2.244-2.654 3.246-5.202 3.004-7.643-0.247-2.446-1.583-4.695-4.01-6.747v0c-2.462-2.082-4.891-3.044-7.288-2.886-2.392 0.162-4.718 1.581-6.98 4.255v0c-0.992 1.173-1.669 2.035-2.031 2.587zM242.411 210.297v0c1.886 1.595 3.273 3.271 4.163 5.028 0.899 1.757 1.358 3.567 1.377 5.431 0.02 1.863-0.387 3.744-1.22 5.641-0.833 1.897-2.027 3.766-3.583 5.605v0c-0.74 0.875-1.613 1.835-2.62 2.883-1.012 1.043-2.057 1.971-3.135 2.785v0l-21.103-17.847c0.623-1.198 1.379-2.389 2.266-3.572 0.893-1.179 1.711-2.208 2.455-3.087v0c1.535-1.815 3.154-3.294 4.858-4.437 1.704-1.143 3.463-1.87 5.278-2.181 1.821-0.307 3.672-0.164 5.554 0.43 1.886 0.589 3.79 1.696 5.71 3.321zM232.706 197.359l1.968-4.374c1.195-0.123 2.63-0.214 4.305-0.274 1.681-0.057 3.432-0.093 5.254-0.108 1.825-0.021 3.67-0.026 5.538-0.013 1.871 0.021 3.598 0.04 5.18 0.055v0c-1.064-1.168-2.227-2.44-3.489-3.813-1.253-1.377-2.477-2.755-3.672-4.135-1.197-1.373-2.332-2.708-3.404-4.004-1.066-1.293-1.95-2.427-2.651-3.403v0l1.92-4.265c1.996 0.63 4.108 1.326 6.335 2.088 2.221 0.76 4.485 1.561 6.792 2.402 2.307 0.842 4.621 1.702 6.941 2.579 2.321 0.877 4.577 1.751 6.77 2.621v0l-2.09 4.646c-3.062-1.262-6.222-2.542-9.478-3.839-3.262-1.301-6.452-2.489-9.569-3.565v0c0.449 0.536 0.99 1.171 1.625 1.907 0.629 0.733 1.316 1.521 2.061 2.365 0.746 0.844 1.519 1.707 2.32 2.59 0.804 0.892 1.581 1.753 2.332 2.585 0.751 0.832 1.452 1.604 2.104 2.318 0.658 0.717 1.217 1.328 1.68 1.834v0l-1.585 3.523c-0.685-0.011-1.52-0.027-2.505-0.049-0.979-0.019-2.028-0.034-3.148-0.044-1.123-0.004-2.284-0.015-3.482-0.031-1.192-0.014-2.345-0.017-3.459-0.01-1.117 0.013-2.164 0.025-3.141 0.035-0.983 0.008-1.811 0.024-2.482 0.048v0c2.87 1.625 5.875 3.224 9.014 4.796 3.131 1.576 6.183 3.094 9.156 4.556v0l-2.086 4.636c-2.106-1.064-4.275-2.181-6.507-3.352-2.232-1.171-4.441-2.343-6.628-3.516-2.191-1.182-4.301-2.349-6.331-3.501-2.03-1.153-3.892-2.249-5.588-3.288z"
                    fill="#7e3ed2" data-fill-palette-color="primary"></path>
                  <path
                    d="M4.476 99.896L6.206 95.539C7.371 95.368 8.77 95.218 10.402 95.09 12.037 94.955 13.743 94.839 15.52 94.739 17.304 94.643 19.107 94.561 20.929 94.493 22.757 94.428 24.442 94.371 25.986 94.322V94.322C24.897 93.227 23.707 92.035 22.416 90.746 21.132 89.46 19.874 88.169 18.643 86.876 17.417 85.584 16.255 84.332 15.155 83.119 14.056 81.906 13.141 80.837 12.41 79.913V79.913L14.1 75.658C16.077 76.187 18.17 76.772 20.38 77.415 22.581 78.061 24.827 78.746 27.118 79.47 29.405 80.186 31.702 80.923 34.008 81.682 36.313 82.441 38.553 83.195 40.728 83.944V83.944L38.892 88.569C35.844 87.472 32.702 86.36 29.467 85.233 26.232 84.105 23.068 83.087 19.973 82.179V82.179C20.438 82.677 20.993 83.271 21.638 83.962 22.282 84.652 22.989 85.392 23.758 86.182 24.519 86.976 25.311 87.789 26.134 88.621 26.96 89.448 27.756 90.252 28.521 91.033 29.293 91.816 30.013 92.541 30.682 93.205 31.349 93.876 31.92 94.448 32.394 94.921V94.921L31.002 98.429C30.332 98.448 29.518 98.47 28.56 98.496 27.603 98.522 26.576 98.552 25.479 98.587 24.386 98.63 23.255 98.672 22.084 98.713 20.917 98.748 19.79 98.796 18.705 98.857 17.613 98.915 16.591 98.968 15.638 99.017 14.683 99.073 13.878 99.127 13.223 99.18V99.18C16.097 100.642 19.098 102.072 22.226 103.471 25.353 104.869 28.402 106.215 31.372 107.508V107.508L29.536 112.132C27.439 111.186 25.274 110.191 23.039 109.147 20.803 108.102 18.591 107.053 16.403 105.999 14.223 104.941 12.114 103.894 10.075 102.856 8.043 101.821 6.177 100.835 4.476 99.896ZM55.351 64.437L44.203 79.599 21.8 63.128 32.377 48.742 35.834 51.283 28.251 61.597 33.78 65.661 40.533 56.476 43.925 58.971 37.172 68.156 43.741 72.985 51.894 61.896ZM59.422 60.772L39.767 41.104 43.342 37.531 62.998 57.199ZM65.76 25.756V25.756C63.403 27.376 62.106 29.347 61.871 31.67 61.632 33.987 62.406 36.447 64.194 39.05V39.05C65.042 40.283 65.965 41.311 66.965 42.135 67.97 42.954 69.013 43.526 70.096 43.851 71.182 44.181 72.298 44.25 73.443 44.057 74.597 43.867 75.758 43.37 76.926 42.568V42.568C77.652 42.069 78.26 41.611 78.752 41.193 79.244 40.774 79.615 40.415 79.866 40.114V40.114L74.209 31.88 78.375 29.017 85.939 40.026C85.52 40.643 84.715 41.554 83.526 42.757 82.345 43.961 80.863 45.177 79.078 46.403V46.403C77.425 47.539 75.732 48.312 73.999 48.724 72.271 49.132 70.578 49.159 68.92 48.804 67.263 48.449 65.661 47.713 64.116 46.598 62.57 45.483 61.14 43.968 59.824 42.053V42.053C58.504 40.132 57.63 38.235 57.201 36.36 56.769 34.48 56.708 32.679 57.018 30.956 57.328 29.232 57.986 27.636 58.992 26.165 59.993 24.699 61.265 23.435 62.809 22.374V22.374C63.868 21.646 64.86 21.073 65.785 20.655 66.712 20.227 67.533 19.896 68.247 19.661 68.966 19.433 69.586 19.284 70.109 19.214 70.626 19.148 70.993 19.104 71.212 19.083V19.083L72.296 23.362C71.362 23.417 70.309 23.643 69.135 24.04 67.966 24.442 66.84 25.014 65.76 25.756ZM101.768 16.892L97.787 6.517 102.506 4.706 112.468 30.667 107.749 32.477 103.337 20.981 92.053 25.31 96.465 36.807 91.746 38.618 81.784 12.658 86.503 10.847 90.484 21.222ZM137.639 27.445L118.98 29.891 115.366 2.32 133.07 0 133.628 4.254 120.936 5.917 121.827 12.721 133.131 11.24 133.678 15.415 122.375 16.896 123.434 24.98 137.081 23.191ZM165.278 30.182L160.997 29.782C160.235 28.182 159.376 26.456 158.418 24.605 157.46 22.753 156.467 20.889 155.439 19.011 154.405 17.125 153.346 15.294 152.261 13.518 151.178 11.734 150.137 10.125 149.141 8.689V8.689L147.293 28.504 142.339 28.042 144.922 0.356 149.045 0.74C150.001 1.96 151.022 3.392 152.105 5.035 153.188 6.679 154.273 8.386 155.357 10.156 156.443 11.92 157.485 13.689 158.483 15.465 159.488 17.234 160.375 18.883 161.143 20.41V20.41L162.858 2.029 167.861 2.496ZM200.264 13.623V13.623C203.898 15.323 206.366 17.29 207.668 19.522 208.976 21.756 208.988 24.244 207.706 26.984V26.984C206.109 30.396 203.342 31.919 199.406 31.553V31.553C199.606 32.327 199.81 33.252 200.015 34.328 200.224 35.397 200.412 36.542 200.58 37.76 200.75 38.973 200.884 40.202 200.982 41.446 201.082 42.685 201.126 43.879 201.115 45.028V45.028L195.997 42.633C195.942 41.547 195.855 40.436 195.737 39.299 195.616 38.168 195.479 37.055 195.326 35.96 195.17 34.871 194.998 33.833 194.81 32.846 194.624 31.852 194.44 30.958 194.256 30.163V30.163C193.903 30.027 193.607 29.903 193.367 29.791 193.121 29.676 192.89 29.568 192.674 29.467V29.467L190.453 28.427 185.995 37.952 181.417 35.81 193.034 10.985C194.262 11.267 195.525 11.661 196.823 12.166 198.122 12.671 199.269 13.157 200.264 13.623ZM198.736 17.732V17.732C197.771 17.28 196.857 16.897 195.996 16.581V16.581L192.187 24.721 194.193 25.66C195.308 26.182 196.316 26.581 197.218 26.857 198.12 27.132 198.93 27.245 199.648 27.193 200.364 27.148 200.993 26.927 201.537 26.531 202.074 26.132 202.535 25.522 202.92 24.7V24.7C203.285 23.921 203.446 23.2 203.406 22.538 203.362 21.866 203.141 21.244 202.744 20.671 202.344 20.104 201.802 19.576 201.117 19.087 200.429 18.605 199.636 18.153 198.736 17.732ZM218.955 24.063L236.438 37.72 233.748 41.164 227.01 35.9 212.582 54.369 208.567 51.233 222.995 32.764 216.265 27.506ZM243.218 51.388L228.328 63.861C228.499 64.107 228.734 64.419 229.034 64.798 229.33 65.172 229.746 65.679 230.282 66.318V66.318C232.463 68.922 234.751 70.308 237.147 70.477 239.542 70.656 241.93 69.748 244.31 67.755V67.755C246.731 65.727 248.061 63.546 248.3 61.213 248.548 58.88 247.573 56.402 245.376 53.778V53.778C244.41 52.626 243.691 51.829 243.218 51.388ZM247.709 71.812V71.812C245.862 73.36 244.018 74.416 242.177 74.982 240.332 75.552 238.51 75.692 236.712 75.402 234.914 75.111 233.174 74.406 231.492 73.284 229.805 72.167 228.205 70.705 226.691 68.898V68.898C225.973 68.041 225.192 67.036 224.349 65.886 223.51 64.74 222.79 63.581 222.189 62.41V62.41L242.895 45.064C243.943 45.862 244.961 46.788 245.949 47.844 246.941 48.904 247.796 49.863 248.515 50.721V50.721C250.011 52.507 251.167 54.315 251.983 56.145 252.804 57.971 253.21 59.785 253.201 61.589 253.192 63.393 252.745 65.154 251.861 66.871 250.981 68.584 249.597 70.231 247.709 71.812ZM264.913 75.315L266.82 79.597C266.129 80.55 265.258 81.655 264.209 82.913 263.163 84.176 262.054 85.478 260.883 86.818 259.706 88.162 258.505 89.509 257.28 90.859 256.048 92.211 254.911 93.457 253.867 94.596V94.596C255.412 94.582 257.096 94.564 258.92 94.542 260.738 94.522 262.54 94.524 264.326 94.547 266.106 94.574 267.814 94.617 269.45 94.678 271.086 94.74 272.49 94.832 273.661 94.955V94.955L275.524 99.137C273.764 100.182 271.882 101.27 269.879 102.402 267.878 103.525 265.819 104.652 263.699 105.785 261.589 106.92 259.457 108.048 257.302 109.167 255.148 110.286 253.043 111.361 250.988 112.392V112.392L248.964 107.847C251.878 106.433 254.869 104.964 257.936 103.438 261.003 101.912 263.943 100.36 266.755 98.781V98.781C266.074 98.766 265.261 98.747 264.317 98.726 263.372 98.705 262.349 98.693 261.247 98.691 260.147 98.681 259.012 98.679 257.841 98.686 256.673 98.699 255.542 98.706 254.448 98.708 253.349 98.712 252.327 98.721 251.384 98.735 250.438 98.744 249.63 98.752 248.96 98.761V98.761L247.425 95.313C247.88 94.821 248.432 94.223 249.083 93.52 249.734 92.817 250.43 92.061 251.172 91.253 251.904 90.441 252.665 89.602 253.453 88.736 254.244 87.877 254.998 87.037 255.713 86.219 256.434 85.397 257.11 84.629 257.741 83.913 258.369 83.191 258.893 82.577 259.312 82.072V82.072C256.258 83.106 253.138 84.253 249.952 85.512 246.766 86.772 243.673 88.012 240.672 89.233V89.233L238.648 84.688C240.79 83.85 243.015 82.996 245.324 82.127 247.633 81.258 249.929 80.409 252.213 79.581 254.493 78.761 256.716 77.984 258.883 77.251 261.043 76.521 263.053 75.876 264.913 75.315Z"
                    fill="#7e3ed2" data-fill-palette-color="primary"></path>
                  <path
                    d="M4.002 143.188c0-6.003 4.866-10.869 10.868-10.869 6.003 0 10.869 4.866 10.869 10.869 0 6.003-4.866 10.869-10.869 10.868-6.003 0-10.869-4.866-10.868-10.868zM254.261 143.188c0-6.003 4.866-10.869 10.869-10.869 6.003 0 10.869 4.866 10.868 10.869 0 6.003-4.866 10.869-10.868 10.868-6.003 0-10.869-4.866-10.869-10.868z"
                    fill="#7e3ed2" data-fill-palette-color="primary"></path>
                </svg>
                <h6>О системе</h6>
                <p class="text-justify">
                  <b>Реконфигурируемая микромодульная система интероперабельности программными компонентами <i>Meighen RTDM </i></b>
                  создана для использования в качестве инструмента для упрощения
                работы разработчиков. аналитиков, dev-ops'ов и прочих специалистов. Система позволяет создавать,
                развертывать и управлять микросервисами в интерактивном режиме.
                Система позволяет сократить затраты на разработку и сопровождение масштабных микросервисных систем,
                использование которых требует большой погруженность специалистов в предметную область.</p>
              </div>

              <div class="col-xs-6 col-md-1">
              {/*  <h6>Categories</h6>*/}
              {/*  <ul class="footer-links">*/}
              {/*    <li><a href="http://scanfcode.com/category/c-language/">C</a></li>*/}
              {/*    <li><a href="http://scanfcode.com/category/front-end-development/">UI Design</a></li>*/}
              {/*    <li><a href="http://scanfcode.com/category/back-end-development/">PHP</a></li>*/}
              {/*    <li><a href="http://scanfcode.com/category/java-programming-language/">Java</a></li>*/}
              {/*    <li><a href="http://scanfcode.com/category/android/">Android</a></li>*/}
              {/*    <li><a href="http://scanfcode.com/category/templates/">Templates</a></li>*/}
              {/*  </ul>*/}
              </div>

              <div class="col-xs-6 col-md-4">
                <h6>Ссылки</h6>
                <ul class="footer-links">
                  <li><a href="/about">О нас</a></li>
                  <li><a href="/contact">Связаться с нами</a></li>
                  <li><a href="/contribute">Поддержать автора</a></li>
                  <li><a href="/privacy-policy">Политика конфиденциальности</a></li>
                  {/*<li><a href="http://scanfcode.com/sitemap/">Sitemap</a></li>*/}
                </ul>
              </div>
            </div>
            <hr />
          </div>
          <div class="container">
            <div class="row">
              <div class="col-md-8 col-sm-6 col-xs-12">
                <p class="copyright-text">Copyright &copy; 2023
                  <br />All Rights Reserved by
                  <a href="/"> Meighen</a>.
                </p>
              </div>

              <div class="col-md-4 col-sm-6 col-xs-12">
                <ul class="social-icons">
                  <li><a class="facebook" href="#"><i class="fa fa-facebook"></i></a></li>
                  <li><a class="twitter" href="#"><i class="fa fa-twitter"></i></a></li>
                  <li><a class="dribbble" href="#"><i class="fa fa-dribbble"></i></a></li>
                  <li><a class="linkedin" href="#"><i class="fa fa-linkedin"></i></a></li>
                </ul>
              </div>
            </div>
          </div>
        </footer>
    );
  }
}

export default Footer;